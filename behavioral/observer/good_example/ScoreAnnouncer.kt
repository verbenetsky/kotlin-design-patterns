package org.example.observer.good_example

class ScoreAnnouncer(private val game: Game) : Observer {

    init {
        game.attach(this)
    }

    override fun update() {
        val (first, second) = game.score
        println("The current score is $first to $second")
    }
}
