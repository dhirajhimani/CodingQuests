package hackerrank.algorithims.string

import hackerrank.FunctionalHelpers._
import scala.collection.mutable
// https://www.hackerrank.com/challenges/two-characters/problem

object TwoCharacters_1 extends App {

  //  val input = "abaacdcbd"
  val input = "beabeefeab"

  TwoCharacters.printLargestAlternateString(input)

}

object TwoCharacters {

  def printLargestAlternateString(input: String) = {
    (get(input) andThen
      getCharCountMap andThen
      getAlternatePossiblePairs andThen
      validateAlternatePair(input) andThen
      printLargestStringFromList) ()



    //      val charCount = getCharCountMap(input)
    //      // pairs could be if the values differ by 1 or 0
    //      val alternatePairs = getAlternatePossiblePairs(charCount.toList)
    //
    //      val longestAlternateStringList = validateAlternatePair(input, alternatePairs)
    //
    //      if (!longestAlternateStringList.isEmpty) {
    //        longestAlternateStringList.sortWith(sortByLength)(0)
    //      } else {
    //        ""
    //      }
  }

  private def getCharCountMap: String => List[(Char, Int)] = {
    input => {
      var charCount: mutable.Map[Char, Int] = collection.mutable.Map[Char, Int]()
      input.foreach(x => {
        charCount += x -> (charCount.getOrElse(x, 0) + 1)
      })
      charCount.foreach(myPrint)
      charCount.toList
    }
  }

  def getAlternatePossiblePairs: List[(Char, Int)] => List[(Char, Char)] = {
    charCount => {
      var possiblePairs = List[(Char, Char)]()
      for (i <- 0 to charCount.length - 1) {
        val m = charCount(i)
        for (j <- i + 1 to charCount.length - 1) {
          val n = charCount(j)
          val diff = m._2 - n._2
          if (diff == 0 || math.abs(diff) == 1) {
            possiblePairs = (m._1, n._1) :: possiblePairs
          }
        }
      }
      possiblePairs.foreach(myPrint)
      possiblePairs
    }
  }

  def validateAlternatePair(input: String): List[(Char, Char)] => List[String] = {
    alternatePairs => {
      var found = false
      var foundedStrings = mutable.ListBuffer[String]()
      alternatePairs.foreach(
        p => {
          var longestString = ""
          input.foreach(x => if (x == p._1 || x == p._2) longestString += x)
          myPrint(longestString)
          found = isStringAlternate(longestString)
          if (found) {
            myPrint("Alternate -> " + longestString)
            foundedStrings += longestString
          }
        }
      )
      foundedStrings.toList
    }
  }

  def isStringAlternate(longestString: String): Boolean = {
    if (longestString.length < 2) {
      true
    } else {
      var diffAlternate = true
      for (i <- 0 until longestString.length - 1 if (diffAlternate)) {
        if (longestString(i) == longestString(i + 1)) {
          diffAlternate = false
        }
      }
      diffAlternate
    }
  }

  private def printLargestStringFromList: List[String] => Unit = {
    longestAlternateStringList =>
      var length = 0
      if (!longestAlternateStringList.isEmpty) {
        length = longestAlternateStringList.sortWith(sortByLength)(0).length
      }
      println(length)
  }

  def myPrint(a: Any): Unit = {
    //    println(a)
  }

  private def sortByLength(s1: String, s2: String) = {
    s1.length > s2.length
  }
}
