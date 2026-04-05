package org.example.strategy


// this code violates Single Responsibility Principle and Open/Closed Principle

class FileCompressor(private val file: String, private val type: String) {

    // whenever we want to add additional compress method we need to rewrite and change existing code
    // also this class have several responsibilities
    // 1. Picking compression method
    // 2. Implementing compression method
    // 3. Storing data
    // so this class have multiple reasons to change its code
    fun compress(): String {
        return when (type) {
            "txt" -> file.filterIndexed { index, _ -> index % 2 == 0 }
            "pdf" -> file.filterIndexed { index, _ -> index % 3 == 0 }
            "epub" -> file.filterIndexed { index, _ -> index % 4 == 0 }
            else -> throw IllegalArgumentException("Unsupported file type")
        }
    }
}

fun main() {
    val txt = FileCompressor("ExampleTextFile", "txt")
    val pdf = FileCompressor("ExamplePdfFile", "pdf")
    val epub = FileCompressor("ExampleEpubFile", "epub")

    println(txt.compress())
    println(pdf.compress())
    println(epub.compress())
}
