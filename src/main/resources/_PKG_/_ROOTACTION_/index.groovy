package _PKG_._ROOTACTION_

def l = namespace(lib.LayoutTagLib.class)

l.layout {
    l.main_panel(title:_("Page title")) {
        h2(_("Your Generateted Root Action ${my.class}"))
        a(href:"hello?name=World", "Say hello to Jenkins")
    }
}