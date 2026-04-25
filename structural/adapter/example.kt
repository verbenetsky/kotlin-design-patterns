package org.example.adapter

// apka oczekuje tego interfejsu:
interface EncodeOctalToBinary {
    fun encodeNumber(number: Int): String
}

// co mamy
class EncodeDecimalToBinary {
    fun encodeBin(number: Int): String {
        return number.toString(2)
    }
}

class EncodingAdapter(
    private val oldEncodingMethod: EncodeDecimalToBinary
) : EncodeOctalToBinary {

    override fun encodeNumber(number: Int): String {
        val decimalNumber = number.toString().toInt(8)
        return oldEncodingMethod.encodeBin(decimalNumber)
    }
}

fun encode(encoder: EncodeOctalToBinary, num: Int) {
    println("Encoded num is: ${encoder.encodeNumber(num)}")
}

fun main() {
    val oldEncoder = EncodeDecimalToBinary()
    val adapter = EncodingAdapter(oldEncoder)

    encode(adapter, 10)
}
