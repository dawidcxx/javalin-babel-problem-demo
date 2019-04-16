package test.test

import io.javalin.Javalin

fun main(args: Array<String>) {
    val jdk = System.getProperty("java.version")
    val app = Javalin.create().apply {
        enableStaticFiles("/public")
    }
    app.get("/") { ctx ->
        ctx.html(
            """
            <head><meta charset="utf-8"></head>
            <body>
                $jdk
                <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-standalone/6.26.0/babel.min.js"></script>
                <script src="/babel.min.js"></script>
            </body>
        """
        )
    }

    app.start(8081)

}
