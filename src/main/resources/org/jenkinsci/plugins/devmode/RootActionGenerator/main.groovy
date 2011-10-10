package org.jenkinsci.plugins.devmode.RootActionGenerator

import org.jenkinsci.plugins.devmode.Generator

def f = namespace(lib.FormTagLib)

include(Generator.class,"main")

f.entry(title:_("Url Name"),field:"_URL_NAME_") {
    f.textbox()
}

f.entry(title:_("Icon"),field:"_ICON_FILENAME_") {
    f.textbox()
}