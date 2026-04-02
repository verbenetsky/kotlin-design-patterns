package org.example.observer.good_example

import kotlin.properties.Delegates.observable

typealias Score = Pair<Int, Int>

abstract class Subject {
    private val observers: MutableList<Observer> = mutableListOf()
    fun attach(observer: Observer) = observers.add(observer)
    fun detach(observer: Observer) = observers.remove(observer)
    protected fun onUpdate() = observers.forEach { it.update() }
}

class Game : Subject() {

    // correct way to do it, but there is a better method
//    var score: Score = 0 to 0
//        set(value) {
//            field = value
//            onUpdate()
//        }

    // more Kotlin style
    var score: Score by observable(0 to 0) { property, oldValue, newValue ->
        onUpdate()
    }

    fun onFirstTeamScore() {
        score = score.copy(first = score.first + 1)
    }

    fun onSecondTeamScore() {
        score = score.copy(second = score.second + 1)
    }
}

fun main() {
    val game = Game()
    val announcer1 = ScoreAnnouncer(game)
    val announcer2 = LeadingTeamAnnouncer(game)

    game.onFirstTeamScore()
    game.onFirstTeamScore()
    game.onSecondTeamScore()
}
