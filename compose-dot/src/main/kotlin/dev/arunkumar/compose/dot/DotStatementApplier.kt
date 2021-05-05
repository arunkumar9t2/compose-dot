package dev.arunkumar.compose.dot

import androidx.compose.runtime.AbstractApplier
import androidx.compose.runtime.Applier
import dev.arunkumar.dot.DotGraph
import dev.arunkumar.dot.Statement

/**
 * Compose [Applier] implementation to manage tree of [DotGraph] instances
 *
 * @param dotGraph Root [DotGraph] instance that will serve as the root node.
 */
internal class DotStatementApplier(dotGraph: DotGraph) : AbstractApplier<Statement>(dotGraph) {

    override fun onClear() {
        // We don't support clearing trees at the moment
    }

    override fun insertBottomUp(index: Int, instance: Statement) {
        // We only implement top down
    }

    override fun insertTopDown(index: Int, instance: Statement) = graphNode {
        add(instance)
    }

    override fun move(from: Int, to: Int, count: Int) {
        // Mutable operations are not supported
    }

    override fun remove(index: Int, count: Int) {
        // Mutable operations are not supported
    }

    /**
     * Executes [action] if the [current] node is a [DotGraph] node
     */
    private fun graphNode(action: DotGraph.() -> Unit) {
        (current as? DotGraph)?.let(action)
    }
}