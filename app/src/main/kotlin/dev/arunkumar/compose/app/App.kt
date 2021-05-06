package dev.arunkumar.compose.app

import dev.arunkumar.compose.dot.Cluster
import dev.arunkumar.compose.dot.DirectedGraph
import java.io.File

fun main() {
    val output: DotOutput = DefaultDotOutput()

    val (dotGraph, _) = DirectedGraph("Hello") {
        "A" {
            "color" `=` "red"
        }
        "A" link "B" {
            "color" `=` "blue"
        }
        Cluster("compilation") {
            "main" link "main.c"
            Cluster("output") {
                "main" link "hello"
            }
        }
    }

    output.render(dotGraph, File("build/output.png"))
}