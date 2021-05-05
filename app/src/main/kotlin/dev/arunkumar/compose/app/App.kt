package dev.arunkumar.compose.app

import dev.arunkumar.compose.dot.Cluster
import dev.arunkumar.compose.dot.DirectedGraph

fun main() {
    val (root, composition) = DirectedGraph("Hello") {
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
    print(root.toString())
    composition.dispose()
}