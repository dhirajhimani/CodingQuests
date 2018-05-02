package hackerrank.challenges.dbs

import scala.collection.mutable

object HackLandElection extends App {

  println(electionWinner(Array("Alex",
    "Michael",
    "Harry",
    "Dave",
    "Michael",
    "Victor",
    "Harry",
    "Alex",
    "Mary",
    "Mary")))

  println(electionWinner(Array("Victor",
    "Veronica",
    "Ryan",
    "Dave",
    "Maria",
    "Maria",
    "Farah",
    "Farah",
    "Ryan",
    "Veronica")))


  def electionWinner(votes: Array[String]): String = {
    import scala.collection.mutable
      val voterVotes = mutable.LinkedHashMap[String, Int]()
      votes.foreach(
        v => {
          voterVotes += v -> (voterVotes.getOrElse(v, 0) + 1)
        }
      )
    voterVotes.toSeq.sortWith(
      (kv1, kv2) => {
        if (kv1._2 == kv2._2)
          kv1._1 > kv2._1
        else
          kv1._2 > kv2._2
      }
    )(0)._1
  }



}
