package _PKG_;

import hudson.model.Job;
import hudson.model.JobProperty;
import hudson.model.JobPropertyDescriptor;
import org.jenkinsci.plugins.devmode.ExtensionMarker;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * @author Kohsuke Kawaguchi
 */
public class _JOBPROPERTY_ extends JobProperty<Job<?,?>> {
    public final String color;

    @DataBoundConstructor
    public _JOBPROPERTY_(String color) {
        this.color = color;
    }

    @ExtensionMarker
    public static class DescriptorImpl extends JobPropertyDescriptor {
        @Override
        public String getDisplayName() {
            return "_DISPLAY_NAME_";
        }
    }
}
