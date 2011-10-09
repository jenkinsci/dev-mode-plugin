package org.jenkinsci.plugins.devmode;

import hudson.Extension;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This dummy annotation is to be replaced durin the template generation
 * with the real {@link Extension} marker.
 *
 * @author Kohsuke Kawaguchi
 */
@Retention(RetentionPolicy.SOURCE)
public @interface ExtensionMarker {
}
