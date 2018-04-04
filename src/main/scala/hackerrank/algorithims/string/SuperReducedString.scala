package hackerrank.algorithims.string

// https://www.hackerrank.com/challenges/reduced-string/problem

object SuperReducedString extends App {

  val input = new java.util.Scanner (System.in).next();

  val reducedString = reduceString(input, 0)
  println(if(reducedString.isEmpty) "Empty String" else reducedString)



  def reduceString(input: String, count: Int): String = {
    if (count == input.length || count + 1 >= input.length) {
      return input
    }
    if (input(count) == input(count + 1)) {
      reduceString(input.substring(0, count) + input.substring(count + 2), 0)
    } else {
      reduceString(input, count + 1)
    }
  }
}
