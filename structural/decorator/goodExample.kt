package org.example.decorator

import java.util.*
import kotlin.time.Clock

interface Logger {
    fun log(message: String)
}

class ConsoleLogger : Logger {
    override fun log(message: String) {
        println(message)
    }
}

abstract class LoggerDecorator(protected val logger: Logger) : Logger

// decorator
class UniqueIdLogger(logger: Logger) : LoggerDecorator(logger) {
    override fun log(message: String) {
        logger.log("${UUID.randomUUID()} $message")
    }
}

class ThreadNameLogger(logger: Logger) : LoggerDecorator(logger) {
    override fun log(message: String) {
        logger.log("$message (on ${Thread.currentThread().name} thread)")
    }
}

class DateTimeLogger(logger: Logger, private val clock: Clock = Clock.System) : LoggerDecorator(logger) {
    override fun log(message: String) {
        logger.log("[${clock.now()}] $message")
    }

}

fun main() {
    val logger = UniqueIdLogger(ThreadNameLogger(DateTimeLogger(ConsoleLogger())))

    logger.log("Application initialized")
}
