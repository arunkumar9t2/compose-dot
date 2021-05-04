package dev.arunkumar.compositree.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
import androidx.compose.runtime.Recomposer
import kotlinx.coroutines.Dispatchers

fun BuildNode(
    parent: Recomposer = Recomposer(Dispatchers.Main),
    content: @Composable () -> Unit
): Pair<Node, Composition> {
    val applier = NodeApplier(Node())
    val composition = Composition(
        applier = applier,
        parent = parent
    ).apply { setContent(content) }
    return applier.root to composition
}

fun main() {
    val (root, composition) = BuildNode {
        Text("Hello") {
            Text("Hi")
            Text("How")
        }
        Text("I am") {
            Text("Good")
        }
    }
    print(root.toString())
    composition.dispose()
}