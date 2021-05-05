package dev.arunkumar.dot

import dev.arunkumar.dot.EdgeOp.DIRECTED
import dev.arunkumar.dot.EdgeOp.UNDIRECTED

enum class EdgeOp(val op: String) {
    UNDIRECTED(" -- "),
    DIRECTED(" -> ")
}

class DirectedDotEdge(
    override val leftNode: Any,
    override val rightNode: Any
) : DotEdge(leftNode, rightNode, DIRECTED)

open class DotEdge(
    open val leftNode: Any,
    open val rightNode: Any,
    private val edgeOp: EdgeOp = UNDIRECTED
) : DotStatement(leftNode.quote() + edgeOp.op + rightNode.quote())
