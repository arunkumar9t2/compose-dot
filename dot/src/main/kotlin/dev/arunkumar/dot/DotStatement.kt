package dev.arunkumar.dot

import java.io.PrintWriter

open class DotStatement(
    protected val name: String
) : Statement() {

    protected val attributes: MutableMap<String, Any> = LinkedHashMap()

    fun addAttribute(name: String, value: Any) {
        attributes[name] = value
    }

    infix fun String.`=`(value: Any) {
        attributes[this] = value
    }

    override fun write(level: Int, writer: PrintWriter) {
        indent(level, writer)
        writer.print(name)
        if (attributes.isNotEmpty()) {
            writer.print(
                attributes
                    .entries
                    .joinToString(
                        separator = ", ",
                        prefix = " [",
                        postfix = "]"
                    ) { (key, value) -> "$key=${value.quote}" }
            )
        }
        writer.println()
    }
}