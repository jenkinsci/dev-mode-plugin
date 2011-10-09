def f = namespace(lib.FormTagLib.class)

f.block {
    a(href:"${rootURL}/${descriptor.clazz.name}", _("Generate a new job property"))
}
