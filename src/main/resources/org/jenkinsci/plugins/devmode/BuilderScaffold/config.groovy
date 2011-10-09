package org.jenkinsci.plugins.devmode.BuilderScaffold
def f = namespace(lib.FormTagLib.class)

f.entry {
    a(href:"${rootURL}/${descriptor.clazz.name}", _("Generate a new builder"))
}
