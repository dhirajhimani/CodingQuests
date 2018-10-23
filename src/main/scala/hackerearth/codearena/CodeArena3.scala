package hackerearth.codearena

import scala.collection.mutable

object CodeArena3 extends App {

  var T: Int = scala.io.StdIn.readLine().trim.toInt

  1.to(T).map(x => {
    scala.io.StdIn.readLine().trim.toInt match {
      case n => {
        val packets: Array[Int] = new Array[Int](n)
        for(i <- 0 until n) {
          packets(i) = scala.io.StdIn.readLine().trim.toInt
        }
        packets.sorted
        minimise(packets)
      }
    }
  })

  def minimise(packets: Array[Int]) = {
    val map = mutable.HashMap[Int, Int]()
    packets.foreach(
      b => {
        map += b -> (map.getOrElse(b, -1) + 1)
      }
    )
    val total = map.values.toList.sum + 1
    println(total)
  }

}