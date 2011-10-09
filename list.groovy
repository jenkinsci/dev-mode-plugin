def list(File root, Closure body) {
    list(root,root, body);
}

def list(File root, File f, Closure body) {
    f.listFiles().each { File c ->
        if (c.isDirectory())    list(root,c,body);
        else                    body(c.path.substring(root.path.length()));
    }
}

def f = new File("${project.basedir}/target/classes/org/jenkinsci/plugins/devmode/files.list")
f.parentFile.mkdirs();
f.withWriter { w ->
    def all = [];

    ["resources","java"].each { d ->
        list(new File("${project.basedir}/src/main/${d}")) { n -> all << n; }
    }

    all.sort()

    all.each { it -> w.println(it) }
}
