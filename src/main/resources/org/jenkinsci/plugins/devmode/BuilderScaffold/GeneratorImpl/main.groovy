package org.jenkinsci.plugins.devmode.BuilderScaffold.GeneratorImpl

def f = namespace(lib.FormTagLib)

f.entry(title:_("Package Name"),field:"_PKGBUILDER_") {
    f.textbox()
}

f.entry(title:_("Class Name"),field:"_BUILDER_") {
    f.textbox()
}

f.entry(title:_("Display Name"),field:"_DISPLAY_NAME_") {
    f.textbox()
}
