package hackerrank.algorithims.implementation

// https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

object BreakingTheRecords extends App {

  println(breakingRecords(Array(10, 5, 20, 20, 4, 5, 2, 25, 1)).mkString(" "))
  println(breakingRecords(Array(3, 4, 21, 36, 10, 28, 35, 5, 24, 42)).mkString(" "))

  def breakingRecords(score: Array[Int]): Array[Int] = {
//    Array[Int](getMaxCount(score), getMinCount(score))
    Array[Int](getCount(score, _ > _), getCount(score, _ < _))
  }

  def getCount(score: Array[Int], f: (Int,Int) => Boolean): Int = {
    var value = score(0)
    score.foldLeft(0)((acc, x) => {
      if (f(x, value)) {
        value = x
        acc + 1
      } else
        acc
    })
  }

  def getMaxCount(score: Array[Int]): Int = {
    var max = score(0)
    var maxCount = 0
    score.foreach(
      x => {
        if (x > max) {
          max = x
          maxCount += 1
        }
      }
    )
    maxCount
  }

  def getMinCount(score: Array[Int]): Int = {
    var min = score(0)
    var minCount = 0
    score.foreach(
      x => {
        if (x < min) {
          min = x
          minCount += 1
        }
      }
    )
    minCount
  }


  def getCount2(score: Array[Int], f: (Int,Int) => Boolean): Int = {
    var value = score(0)
    var count = 0
    score.foreach(
      x => {
        if (f(x,value)) {
          value = x
          count += 1
        }
      }
    )
    count
  }
}
