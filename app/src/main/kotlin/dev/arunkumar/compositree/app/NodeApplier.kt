package dev.arunkumar.compositree.app

import androidx.compose.runtime.AbstractApplier

class NodeApplier(root: Node) : AbstractApplier<Node>(root) {

    override fun onClear() {
        root.clear()
    }

    override fun insertBottomUp(index: Int, instance: Node) {
    }

    override fun insertTopDown(index: Int, instance: Node) {
        current.children.add(index, instance)
    }

    override fun move(from: Int, to: Int, count: Int) {
        current.children.move(from, to, count)
    }

    override fun remove(index: Int, count: Int) {
        current.children.remove(index, count)
    }
}