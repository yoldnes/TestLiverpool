package com.example.testliverpool.common

fun String.formatAsCurrency(): String =
    try {
        val cleanString = this.replace("[^\\d.]".toRegex(), "")
        val amount = cleanString.ifEmpty { "0" }.toDouble()
        val formatter = java.text.DecimalFormat("#,###.00")
        formatter.isGroupingUsed = true
        formatter.groupingSize = 3
        "$" + formatter.format(amount)
    } catch (e: Exception) {
        "$0.00"
    }

fun String.strikeThrough(): String {
    val strikeChar = '\u0336'
    return this.map { "$it$strikeChar" }.joinToString("")
}
