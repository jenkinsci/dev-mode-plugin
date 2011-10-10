package org.jenkinsci.plugins.devmode;

import hudson.Extension;
import hudson.model.RootAction;
import hudson.util.HttpResponses;
import org.kohsuke.stapler.HttpResponse;
import org.kohsuke.stapler.QueryParameter;

/**
 * @author Kohsuke Kawaguchi
 */
@Extension
public class RootActionGenerator extends Generator implements RootAction {
    public String getIconFileName() {
        return "setting.png";
    }

    public String getDisplayName() {
        return "Generate a new RootAction";
    }

    @Override
    public boolean isTemplate(String path) {
        return path.startsWith("/_PKG/_ROOTACTION_");
    }

    public HttpResponse doHello(@QueryParameter String name) {
        return HttpResponses.plainText("Hello, "+name);
    }
}
