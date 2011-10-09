package org.jenkinsci.plugins.devmode.Generator

def l = namespace(lib.LayoutTagLib)
def f = namespace(lib.FormTagLib)

l.layout {
    l.main_panel {
        h2("Generated")

        ul {
            files.each { file ->
                li(file)
            }
        }
    }
}
