package dev.arunkumar.dot

import java.util.regex.Matcher

val Any.quote get() = '"' + toString().replace("\"".toRegex(), Matcher.quoteReplacement("\\\"")) + '"'