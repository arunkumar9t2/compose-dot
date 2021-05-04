package dev.arunkumar.compositree.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode


open class Node {
    val children = mutableListOf<Node>()

    open val buildValue: String = ""

    fun clear() {
        children.forEach { it.clear() }
        children.clear()
    }

    override fun toString(): String = buildString {
        print("", true, this)
    }

    private fun print(prefix: String, isTail: Boolean, result: StringBuilder) {
        val suffix = if (isTail) "    " else "│   "

        result.apply {
            append(prefix)
            append(if (isTail) "└── " else "├── ")
            append(buildValue)
            append("\n")
        }

        for (i in 0 until children.size - 1) {
            val child = children[i]
            child.print(prefix + suffix, false, result)
        }
        if (children.isNotEmpty()) {
            children.last().print(prefix + suffix, true, result)
        }
    }
}

class TextNode(var text: String = "") : Node() {
    override val buildValue = text
}

@Composable
fun Text(text: String, content: @Composable () -> Unit = {}) {
    ComposeNode<TextNode, NodeApplier>(
        factory = { TextNode(text) },
        update = {},
        content = content
    )
}
