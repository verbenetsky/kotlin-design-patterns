package org.example.observer.good_example

class LeadingTeamAnnouncer(private val game: Game) : Observer {

    init {
        game.attach(this)
    }

    override fun update() {
        val (first, second) = game.score
        val ann = when {
            first > second -> "The first team is in the lead"
            second > first -> "The second team is in the lead"
            else -> {}
        }
        println(ann)
    }
}
