package hackerrank.challenges

// https://www.hackerrank.com/contests/w37/challenges/simple-language

object SimpleLanguage extends App {

  println(maximumProgramValue(5))

  def maximumProgramValue(n: Int): Long = {
    var x = 0.toLong
    for (i <- 1 to n) {
      val line = scala.io.StdIn.readLine().trim
      val value = line.split(" ")(1).toLong
      if (line.startsWith("a")) {
        if (value > 0) {
         x += value
        }
      } else {
        if (value > x) {
          x = value
        }
      }
    }
    x
  }



}
