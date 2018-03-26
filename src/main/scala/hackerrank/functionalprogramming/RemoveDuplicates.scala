package hackerrank.functionalprogramming

// https://www.hackerrank.com/challenges/remove-duplicates

object RemoveDuplicates extends App {

  println(scala.io.StdIn.readLine().foldLeft("")((acc:String , x) => if (acc.contains(x)) acc else acc + x))
  scala.io.StdIn.readLine().distinct
}
