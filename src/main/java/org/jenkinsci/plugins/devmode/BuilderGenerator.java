package org.jenkinsci.plugins.devmode;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;

/**
 * @author Kohsuke Kawaguchi
 */
public class BuilderGenerator extends Builder {
    @Extension
    public static class DescriptorImpl extends BuildStepDescriptor<Builder> {
        @Override
        public boolean isApplicable(Class<? extends AbstractProject> jobType) {
            return true;
        }

        @Override
        public String getDisplayName() {
            return "Generate a new Builder";
        }
    }

    @Extension
    public static class GeneratorImpl extends Generator {
        public String getDisplayName() {
            return "Generate a new Builder";
        }

        @Override
        public boolean isTemplate(String path) {
            return path.startsWith("/_PKG_/_BUILDER_");
        }
    }
}
