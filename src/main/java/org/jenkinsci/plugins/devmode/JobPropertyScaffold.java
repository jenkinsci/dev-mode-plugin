package org.jenkinsci.plugins.devmode;

import hudson.Extension;
import hudson.model.Job;
import hudson.model.JobProperty;
import hudson.model.JobPropertyDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * @author Kohsuke Kawaguchi
 */
public class JobPropertyScaffold extends JobProperty<Job<?,?>> {
    @DataBoundConstructor
    public JobPropertyScaffold() {
    }

    @Extension
    public static class DescriptorImpl extends JobPropertyDescriptor {
        @Override
        public String getDisplayName() {
            return "Implement a new JobProperty";
        }
    }

    @Extension
    public static class GeneratorImpl extends Generator {
        public String getDisplayName() {
            return "Generate a new job property";
        }

        @Override
        public boolean isTemplate(String path) {
            return path.startsWith("/_PKG_/_JOBPROPERTY_");
        }
    }
}
