package dev.arunkumar.dot

import java.util.regex.Matcher

fun Any.quote() = '"' + toString().replace("\"".toRegex(), Matcher.quoteReplacement("\\\"")) + '"'