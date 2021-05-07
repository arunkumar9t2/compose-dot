package dev.arunkumar.compose.dot

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import dev.arunkumar.dot.DotGraph
import dev.arunkumar.dot.quote

@Composable
fun SubGraph(name: String, content: @Composable DotGraphScope.() -> Unit) {
  val dotGraph = DotGraph("subgraph $name")
  ComposeNode<DotGraph, DotStatementApplier>(
    factory = { dotGraph },
    update = {},
    content = {
      content(DotGraphScope(dotGraph))
    }
  )
}

@Composable
fun Cluster(name: String, label: Boolean = true, content: @Composable DotGraphScope.() -> Unit) {
  SubGraph("cluster_$name".quote) {
    if (label) {
      graph {
        "label" `=` name
      }
    }
    content()
  }
}
