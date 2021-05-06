package dev.arunkumar.dot

import java.io.PrintWriter

class DotGraph(private val header: String) : Statement() {

    private val elements: MutableList<Statement> = mutableListOf()

    fun add(statement: Statement) {
        elements.add(statement)
    }

    override fun write(level: Int, writer: PrintWriter) {
        indent(level, writer)
        writer.println("$header {")
        for (element in elements) {
            element.write(level + 1, writer)
        }
        indent(level, writer)
        writer.println("}")
    }
}
