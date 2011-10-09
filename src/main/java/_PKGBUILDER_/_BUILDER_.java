package _PKGBUILDER_;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;

/**
 * @author Kohsuke Kawaguchi
 */
public class _BUILDER_ extends Builder {
    private String name;

    @DataBoundConstructor
    public _BUILDER_(String name) {
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
        listener.getLogger().println("Hello "+name+"!");
        return true;
    }

    @Extension
    public static class DescriptorImpl extends BuildStepDescriptor<Builder> {
        @Override
        public boolean isApplicable(Class<? extends AbstractProject> jobType) {
            return true;
        }

        @Override
        public String getDisplayName() {
            return "_DISPLAY_NAME_";
        }
    }
}
