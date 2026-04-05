package org.example.strategy

interface Compress {
    fun compress(file: String): String
}

class TxtCompressionStrategy : Compress {
    override fun compress(file: String): String {
        val compressedFile = file.filterIndexed { index, ch ->
            index % 2 == 0
        }
        return compressedFile
    }
}

class PdfCompressionStrategy : Compress {
    override fun compress(file: String): String {
        val compressedFile = file.filterIndexed { index, ch ->
            index % 3 == 0
        }
        return compressedFile
    }
}

class EpubCompressionStrategy : Compress {
    override fun compress(file: String): String {
        val compressedFile = file.filterIndexed { index, ch ->
            index % 4 == 0
        }
        return compressedFile
    }
}

class CompressionContext (val value: String, private val compress: Compress) {
    fun compress(): String {
        return compress.compress(value)
    }
}

fun main () {
    val txt = CompressionContext("ExampleTextFile", TxtCompressionStrategy())
    val pdf = CompressionContext("ExamplePdfFile", PdfCompressionStrategy())
    val epub = CompressionContext("ExampleEpubFile", EpubCompressionStrategy())

    println(txt.compress())
    println(pdf.compress())
    println(epub.compress())
}
