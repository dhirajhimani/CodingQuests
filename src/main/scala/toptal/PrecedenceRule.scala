package toptal

import scala.collection.mutable

object PrecedenceRule extends App {


  findWord(List("I>N", "A>I", "P>A", "S>P"))

  findWord(List("U>N", "G>A", "R>Y", "H>U", "N>G", "A>R")) // HUNGARY
  findWord(List("I>F", "W>I", "S>W", "F>T")) // SWIFT
  findWord(List("R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G")) // PORTUGAL
  findWord(List("W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T")) // SWITZERLAND


  def findWord(words: List[String]): String = {
    val map = mutable.HashMap[String, String]()
    words.foreach(word => {
      val kv = word.split(">")
      map += kv(0) -> kv(1)
    })
//    println(map)
    val mapList = map.toSeq.toList
    val word = findWholeWord(mapList, map)
    println(word)
    word
  }


  def findWholeWord(mapList: List[(String, String)],
                    map: mutable.HashMap[String, String]): String = {
    var found = false
    val wordLength = map.size + 1
    var foundWord = ""

    for (elem <- mapList) {
      if (!found) {
        var build = elem._1 + elem._2

        def go(start: String, count: Int): String = {
          val maybeValue = map.get(start)
          if (maybeValue.isDefined) {
            val next = maybeValue.get
            build = build + next
            go(next, count + 1)
          } else {
            build
          }
        }

        foundWord = go(elem._2, 2)
        found = foundWord.size == wordLength
      }
    }
    foundWord
  }
}
