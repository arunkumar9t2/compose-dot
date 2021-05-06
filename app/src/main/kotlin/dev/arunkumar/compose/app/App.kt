package dev.arunkumar.compose.app

import dev.arunkumar.compose.dot.Cluster
import dev.arunkumar.compose.dot.DirectedGraph
import java.io.File

fun main() {
    val output: DotOutput = DefaultDotOutput()

    val (dotGraph, _) = DirectedGraph("Hello") {
        nodeAttributes {
            "shape" `=` "rectangle"
        }
        Cluster("Container A") {
            "Item 1" link "Item 2"
        }
        Cluster("Container B") {
            "Item 3" link "Item 4"
        }
        Cluster("Container C") {
            "Item 5" {
                "color" `=` "blue"
            }
            Cluster("Inner Container") {
                "Item 6" {
                    "color" `=` "red"
                }
            }
        }

        "Item 1" link "Item 4"
        "Item 2" link "Item 5"
        "Item 6" link "Item 3"
    }

    output.render(dotGraph, File("build/output.png"))
}