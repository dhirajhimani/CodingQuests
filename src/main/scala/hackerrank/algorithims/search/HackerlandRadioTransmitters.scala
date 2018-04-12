package hackerrank.algorithims.search

import scala.collection.mutable

//https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem
// Uses lots of memory, timeout Exception
object HackerlandRadioTransmitters extends App {

    println(hackerlandRadioTransmitters(Array(1,2,3,4,5), 1))
  println(hackerlandRadioTransmitters(Array(7, 2, 4, 6, 5, 9, 12, 11), 2))
  println(hackerlandRadioTransmitters(Array(1, 4, 5, 7), 2))

  def hackerlandRadioTransmitters(x: Array[Int], k: Int): Int = {
//    scala.util.Sorting.quickSort(x)
//        println(x.mkString(" "))
    val size = x.max + 1;
    val antennas = Array.range(0, size)
    val visited = Array.fill(size)(false)
//    println(antennas.mkString(" "))
    val coverageArea = 2 * k + 1
    var totalAntennas = 0
    var tempCover = coverageArea
    var coveredHalf = coverageArea / 2
    //    println(coveredHalf)
    var lastAntennaPos = 0;
    for (i <- 0 until size) {
      var antennaRange = i + coveredHalf;
      if (x.contains(i) && !visited(i)) {
        if (x.contains((antennaRange))) {
          for (j <- i to (i + coverageArea - 1)) {
            if (j < size) {
              visited(j) = true
            }
          }
          totalAntennas += 1
        } else if (x.contains(i) && (antennaRange + 1) > size) {
          for (j <- i until (antennaRange)) {
            if (j < size) {
              visited(j) = true
            }
          }
          totalAntennas += 1
        } else {
          //TODO for half area calculation remains

//          println(tempAntenna.mkString(" "))
          val antennaCoveredMap = mutable.HashMap[Int, Int]()
          for (j <- i to antennaRange) {
            if (x.contains(j)) {

              val low = j - coveredHalf
              val high = j + coveredHalf
              for (k <- low to high) {
                if (k > 0 && k < size) {
                  if (!visited(k) && x.contains((k))) {
                    antennaCoveredMap += j -> (antennaCoveredMap.getOrElse(j, 0) + 1)
                  }
                }
              }
            }
          }
//          println(antennaCoveredMap)
//          println(antennaCoveredMap.toSeq.sortWith(_._2 > _._2)(0)._1)
          val antennaHouseIndex = antennaCoveredMap.toSeq.sortWith(_._2 > _._2)(0)._1

          val low = antennaHouseIndex - coveredHalf
          val high = antennaHouseIndex + coveredHalf
          for (k <- low to high) {
            if (k > 0 && k < size) {
              visited(k) = true
            }
          }
          totalAntennas += 1

        }
//        println(antennas(i) + " ")
//        println(visited.mkString(" "))

      }
    }
    totalAntennas
  }

}
