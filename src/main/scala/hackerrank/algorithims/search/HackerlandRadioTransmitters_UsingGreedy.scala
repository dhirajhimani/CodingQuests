package hackerrank.algorithims.search

import scala.collection.mutable

//https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem
object HackerlandRadioTransmitters_UsingGreedy extends App {

    println(hackerlandRadioTransmitters(Array(1,2,3,4,5), 1))
  println(hackerlandRadioTransmitters(Array(7, 2, 4, 6, 5, 9, 12, 11), 2))
  println(hackerlandRadioTransmitters(Array(1, 4, 5, 7), 2))
  println(hackerlandRadioTransmitters(Array(1, 8), 1))

  def hackerlandRadioTransmitters(x: Array[Int], k: Int): Int = {
    scala.util.Sorting.quickSort(x)
    var numOfTransmitters = 0;
    var i = 0;
    val n = x.size
    while (i < n) {
      numOfTransmitters += 1;
      var loc = x(i) + k;
      while (i < n && x(i) <= loc) i += 1;
      i -= 1
      loc = x(i) + k;
      while (i < n && x(i) <= loc) i += 1;
    }
    numOfTransmitters;
  }

}
