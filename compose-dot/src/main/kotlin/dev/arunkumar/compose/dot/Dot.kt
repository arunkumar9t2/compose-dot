package dev.arunkumar.compose.dot

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
import androidx.compose.runtime.Recomposer
import dev.arunkumar.dot.*
import kotlinx.coroutines.Dispatchers

@DslMarker
annotation class DotDslScope

@DotDslScope
inline class DotGraphScope(val dotGraph: DotGraph) {

    inline operator fun String.invoke(nodeBuilder: DotNode.() -> Unit = {}): String {
        dotGraph.add(DotNode(this).apply(nodeBuilder))
        return this
    }

    infix fun String.link(target: String): EdgeBuilder {
        val dotEdge = DirectedDotEdge(this, target).also(dotGraph::add)
        return EdgeBuilder(dotEdge)
    }
}

@DotDslScope
class EdgeBuilder(private val dotEdge: DotEdge) {
    operator fun invoke(edgeBuilder: DotEdge.() -> Unit) {
        dotEdge.apply(edgeBuilder)
    }
}

fun DirectedGraph(
    name: String,
    parent: Recomposer = Recomposer(Dispatchers.Main),
    content: @Composable DotGraphScope.() -> Unit
): Pair<DotGraph, Composition> {
    val dotGraph = DotGraph("digraph ${name.quote}")

    val applier = DotStatementApplier(dotGraph)
    val composition = Composition(applier = applier, parent = parent)
    composition.setContent {
        content(DotGraphScope(dotGraph))
    }
    return applier.root as DotGraph to composition
}