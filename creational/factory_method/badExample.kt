package org.example.factory_method

interface Notification {
    fun send(mess: String)
}

class EmailNotification : Notification {
    override fun send(mess: String) {
        println("Send via email: $mess")
    }
}

class PhoneNumberNotification : Notification {
    override fun send(mess: String) {
        println("Send phone number: $mess")
    }
}

class MessengerNotification : Notification {
    override fun send(mess: String) {
        println("Send via messenger: $mess")
    }
}

// violated open/closed principle
// violated Single Responsibility Principle
// violated Dependency Inversion Principle

class NotificationService {
    fun notifyUser(type: String, mess: String) {
        val notification: Notification =
            when (type) {
                "email" -> EmailNotification()
                "phone" -> PhoneNumberNotification()
                "messenger" -> MessengerNotification()
                else -> throw IllegalArgumentException("Unknown notification type")
            }

        notification.send(mess)
    }
}

fun main() {
    val n = NotificationService()

    n.notifyUser("email", "Hello")
}
