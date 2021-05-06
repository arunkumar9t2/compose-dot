package dev.arunkumar.compose.app

import dev.arunkumar.dot.DotGraph
import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.engine.Graphviz
import java.io.File

interface DotOutput {
  fun render(dotGraph: DotGraph, output: File)
}

class DefaultDotOutput : DotOutput {
  override fun render(dotGraph: DotGraph, output: File) {
    Graphviz.fromString(dotGraph.toString())
      .render(Format.PNG)
      .toFile(output)
  }
}
