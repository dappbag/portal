// # 获得groovy文件所在目录为rootPath
def rootPath = new File(".").getCanonicalPath()

// # timestamp
def timestamp = "built at ${new Date().format('yyyy-MM-dd HH:mm:ss')}"

// # 编译页面（将_*.html 编译到 html文件）
def htmlReplacementMap = [:]

// 把src目录里面的下划线开头的html文件放入到 htmlReplacementMap
new File("${rootPath}/src").eachFile { file ->
    if (!file.isDirectory()) {
        def fileName = file.getName()
        if (fileName.startsWith("_"))
            htmlReplacementMap.put fileName, file.text
    }

}


htmlReplacementMap.put "_RP_CURRENT_TIME", "${System.currentTimeMillis()}"

// 替换src目录里面非下划线开头的html文件中的 html 引用
new File("${rootPath}/src").eachFile { file ->
    if (!file.isDirectory()) {
        def fileName = file.getName()

        if (!fileName.startsWith("_")) {
            def html = file.text

            htmlReplacementMap.each { name, text ->
                html = html.replaceAll(name, text)
            }

            new File("${rootPath}/docs/${fileName}").newWriter().withWriter { w ->
                w << html
            }
        }
    }
}

// # 编译js（将 _*.js 编译进入js文件）
def jsReplacementMap = [:]

// 将src/js目录的的 下划线开头的js收集到  jsReplacementMap
new File("${rootPath}/src/js").eachFile { file ->
    if (!file.isDirectory()) {
        def fileName = file.getName()
        if (fileName.startsWith("_"))
            jsReplacementMap.put fileName, file.text
    }
}

// 用 jsReplacementMap 里面的文件替换js文件并copy js文件到 docs/js 目录
def docJsFolder = new File("${rootPath}/docs/js")
if (!docJsFolder.exists())
    docJsFolder.mkdir()

new File("${rootPath}/src/js").eachFile { file ->
    if (!file.isDirectory()) {
        def fileName = file.getName()

        if (!fileName.startsWith("_")) {
            def jsCode = file.text

            jsReplacementMap.each { name, text ->
                jsCode = jsCode.replaceAll("//${name}", text)
            }

            jsCode = "//${timestamp}\n" + jsCode

            new File("${rootPath}/docs/js/${fileName}").newWriter().withWriter { w ->
                w << jsCode
            }
        }
    }
}

// # copy resources
["res"].each { folder ->
    new AntBuilder().copy(todir: "${rootPath}/docs/${folder}") {
        fileset(dir: "${rootPath}/src/${folder}")
    }
}



println "${timestamp} ended"


