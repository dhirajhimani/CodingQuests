package hackerearth.codearena

import scala.collection.mutable.ArrayBuffer

object CodeArena7 extends App {

  val T = scala.io.StdIn.readLine().trim.toInt

  for (i <- 1 to T) {
    val A1_A2_C_N = scala.io.StdIn.readLine().trim.split(" ").map(_.toInt)
    val N = A1_A2_C_N(3)

    var a0:Int =  A1_A2_C_N(0)
    var a1:Int = A1_A2_C_N(1)
    val c:Int = A1_A2_C_N(2)
    var ans = (a0 * 10 + a1) % 41
    for (i <- 2 until N) {
      val a2 = ((a1 * c) + a0) % 10
      ans = (ans * 10 + a2) % 41
      a0 = a1
      a1 = a2
    }

    if (ans % 41 == 0) {
      println("YES")
    } else {
      println("NO")
    }
  }
}