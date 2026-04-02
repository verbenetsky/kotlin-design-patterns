package org.example.observer.bad_example

class LeadingTeamAnnouncer {
    fun announceLeadingTeam(score: Score) {
        val (first, second) = score
         val ann =  when {
             first > second -> "The first team is in the lead"
             second > first -> "The second team is in the lead"
             else -> {}
         }
        println(ann)
    }
}
