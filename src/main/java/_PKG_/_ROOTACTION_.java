package _PKG_;

import hudson.model.RootAction;
import org.jenkinsci.plugins.devmode.ExtensionMarker;

/**
 * @author Kohsuke Kawaguchi
 */
@ExtensionMarker
public class _ROOTACTION_ implements RootAction {
    public String getIconFileName() {
        return "_ICON_FILENAME_";
    }

    public String getDisplayName() {
        return "_DISPLAY_NAME_";
    }

    public String getUrlName() {
        return "_URL_NAME_";
    }
}
