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
}
