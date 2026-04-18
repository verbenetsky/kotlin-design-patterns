package org.example.decorator

import java.util.UUID
import kotlin.time.Clock

// Violates the Single Responsibility Principle.
// The Logger class knows too much and does too much.
// It decides what should be logged and also performs the logging itself.

// Adding new logging features requires modifying the existing class,
// which violates the Open/Closed Principle.
class Logger(
    private val includeDateTime: Boolean,
    private val includeThreadName: Boolean,
    private val includeUniqueId: Boolean,
    private val clock: Clock,
) {
    fun log(message: String) {
        if (includeDateTime) print("[${clock.now()}] ")
        if (includeUniqueId) print("${UUID.randomUUID()} ")
        print(message)
        if (includeThreadName) print(" on ${Thread.currentThread().name} thread")
        println()
    }
}

fun main() {
    val logger = Logger(
        includeDateTime = true,
        includeThreadName = true,
        includeUniqueId = true,
        clock = Clock.System
    )

    logger.log("Application initialized")
}
