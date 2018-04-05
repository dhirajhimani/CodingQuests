package hackerrank.algorithims.string

import scala.collection.mutable

// https://www.hackerrank.com/challenges/two-characters/problem

object TwoCharacters extends App {

//  val input = "abaacdcbd"
  val input = "beabeefeab"

  println(getAlternateChars(input).length)

  def getAlternateChars: String => String = {
    input => {
      val charCount = getCharCountMap(input)
      // pairs could be if the values differ by 1 or 0
      val alternatePairs = getAlternatePossiblePairs(charCount.toList)

      val longestAlternateStringList = validateAlternatePair(input, alternatePairs)

      if (!longestAlternateStringList.isEmpty) {
        longestAlternateStringList.sortWith(sortByLength)(0)
      } else {
        ""
      }
    }
  }

  private def getCharCountMap: String => mutable.Map[Char, Int] = {
    input => {
      var charCount = collection.mutable.Map[Char, Int]()
      input.foreach(x => {
        charCount += x -> (charCount.getOrElse(x, 0) + 1)
      })
      charCount.foreach(myPrint)
      charCount
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

  def validateAlternatePair: (String, List[(Char, Char)]) => List[String] = {
    (input,  alternatePairs) => {
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
      for (i <- 0 until longestString.length - 1 if(diffAlternate)) {
        if (longestString(i) == longestString(i+1)) {
          diffAlternate = false
        }
      }
      diffAlternate
    }
  }

  def myPrint(a: Any): Unit = {
    //    println(a)
  }

  private def sortByLength(s1: String, s2: String) = {
    s1.length > s2.length
  }
}
