package org.example.observer.bad_example

typealias Score = Pair<Int, Int>

// tight coupling

// and also dependencies inversion is violated
// High-level modules should not depend on low-level modules. Both should depend on abstractions.
// Abstractions should not depend on details. Details should depend on abstractions.
class Game(
    private val scoreAnnouncer: ScoreAnnouncer,
    private val leadingTeamAnnouncer: LeadingTeamAnnouncer
) {
    private var score: Score = 0 to 0
        set(value) {
            field = value
            scoreAnnouncer.announceScore(value)
            leadingTeamAnnouncer.announceLeadingTeam(value)
        }

    fun onFirstTeamScore() {
        score = score.copy(first = score.first + 1)
    }

    fun onSecondTeamScore() {
        score = score.copy(second = score.second + 1)
    }
}

fun main() {
    val game = Game(ScoreAnnouncer(), LeadingTeamAnnouncer())

    game.onFirstTeamScore()
    game.onFirstTeamScore()
    game.onSecondTeamScore()
}
