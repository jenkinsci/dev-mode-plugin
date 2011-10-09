package org.jenkinsci.plugins.devmode.BuilderScaffold
def f = namespace(lib.FormTagLib.class)

f.entry {
    raw("<a href='${rootURL}/${descriptor.clazz.name}'>Generate a new builder</a>")
}
