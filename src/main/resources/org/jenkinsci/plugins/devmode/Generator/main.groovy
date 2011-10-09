package org.jenkinsci.plugins.devmode.Generator

import hudson.model.Describable

def f = namespace(lib.FormTagLib)

f.entry(title:_("Package Name"),field:"_PKG_") {
    f.textbox()
}

f.entry(title:_("Class Name"),field:"_BUILDER_") {
    f.textbox()
}

if (Describable.class.isAssignableFrom(my.extensionPointType)) {
    f.entry(title:_("Display Name"),field:"_DISPLAY_NAME_") {
        f.textbox()
    }
}
