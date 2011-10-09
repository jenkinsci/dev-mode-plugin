package org.jenkinsci.plugins.devmode;

import hudson.Extension;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.model.RootAction;
import hudson.util.HttpResponses;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.HttpResponse;
import org.kohsuke.stapler.StaplerRequest;

import javax.servlet.ServletException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Performs the actual code generation.
 * 
 * @author Kohsuke Kawaguchi
 */
public abstract class Generator implements RootAction {
    public final Class extensionPointType;

    protected Generator() {
        this.extensionPointType = getClass().getEnclosingClass();
        if (extensionPointType==null)
            throw new IllegalStateException(getClass()+" isn't a nested type. Use a no-arg constructor to specify the type.");
    }

    protected Generator(Class extensionPointType) {
        this.extensionPointType = extensionPointType;
    }

    public String getIconFileName() {
        return null;
    }

    public String getUrlName() {
        return getClass().getEnclosingClass().getName();
    }

    /**
     * Template prefix
     */
    public abstract boolean isTemplate(String path);

    public HttpResponse doGenerate(StaplerRequest req) throws ServletException, IOException {
        Map<String,String> vars = new HashMap<String, String>();

        JSONObject o = req.getSubmittedForm();
        for (String key : (Set<String>)o.keySet()) {
            if (key.startsWith("_") && key.endsWith("_")) {
                vars.put(key,o.getString(key));
            }
        }

        vars.put("@ExtensionMarker","@Extension");
        vars.put(ExtensionMarker.class.getName(),Extension.class.getName());

        BufferedReader r = open("files.list");
        List<File> generatedFiles = new ArrayList<File>();
        String line;
        while ((line=r.readLine())!=null) {
            if (isTemplate(line)) {
                generatedFiles.add(applyTemplate(line, vars));
            }
        }
        
        return HttpResponses.forwardToView(this,"ok").with("files",generatedFiles);
    }

    private BufferedReader open(String resName) throws IOException {
        InputStream res = getClass().getResourceAsStream(resName);
        if (res==null)  throw new IOException("Non-existent template: "+resName);
        return new BufferedReader(new InputStreamReader(res,"UTF-8"));
    }

    public File applyTemplate(String resourceName, Map<String,String> vars) throws IOException {
        File moduleRoot = getModuleRoot();

        String header = resourceName.endsWith(".java") ? "/src/main/java" : "/src/main/resources";

        File output = new File(new File(moduleRoot,header), replace(resourceName, vars));
        output.getParentFile().mkdirs();

        if (output.exists())
            throw new IllegalStateException(output+" already exists");

        PrintWriter f = new PrintWriter(new FileWriter(output));
        BufferedReader r = open(resourceName);
        try {
            String line;
            while ((line=r.readLine())!=null) {
                f.println(replace(line, vars));
            }
        } finally {
            f.close();
            r.close();
        }

        return output;
    }

    private File getModuleRoot() {
        String moduleRoot = System.getProperty("jenkins.moduleRoot");
        if (moduleRoot==null)   throw new IllegalStateException("jenkins.moduleRoot is not set. Perhaps you are using an old version of maven-hpi-plugin?");
        return new File(moduleRoot);
    }

    /**
     * Performs the variable expansions.
     *
     * TODO: we shouldn't expand the result of expansion.
     */
    private String replace(String s, Map<String, String> vars) {
        for (Entry<String, String> e : vars.entrySet()) {
            s = s.replace(e.getKey(),e.getValue());
        }
        return s;
    }

    public String get_PKG_() {
        return inferPackage(new File(getModuleRoot(),"src/main/java"));
    }

    private String inferPackage(File srcDir) {
        StringBuilder name = new StringBuilder();

        while (true) {
            File[] children = srcDir.listFiles(new FileFilter() {
                public boolean accept(File f) {
                    return f.isDirectory();
                }
            });
            if (children!=null && children.length==1) {
                if (name.length()>0)    name.append('.');
                name.append(children[0].getName());
                srcDir = children[0];
                continue;
            }

            return name.toString();
        }
    }
}
