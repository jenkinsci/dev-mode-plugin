package org.jenkinsci.plugins.devmode.Generator

def l = namespace(lib.LayoutTagLib)
def f = namespace(lib.FormTagLib)

l.layout {
    l.main_panel {
        h2(my.displayName)

        f.form(action:"generate", method:"post") {
            include(my,"main") // main section in the main.groovy
        }
    }
}
