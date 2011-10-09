package org.jenkinsci.plugins.devmode.BuilderScaffold
def f = namespace(lib.FormTagLib.class)

f.entry {
    raw("<a href='${rootURL}/${my.class.name}'>Generate a new builder</a>")
}
