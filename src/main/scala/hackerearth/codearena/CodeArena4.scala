package hackerearth.codearena

import scala.collection.mutable

object CodeArena4 extends App {

  var N_Q = scala.io.StdIn.readLine().trim.split(" ").map(_.toInt)

  var B: mutable.TreeSet[Int] = new mutable.TreeSet[Int]

  scala.io.StdIn.readLine().trim.split(" ").foreach(x => {
    B += x.toInt
  })

  for (i <- 1.to(N_Q(1))) {
    if (B.contains(scala.io.StdIn.readLine().trim.toInt))
      println("YES")
    else
      println("NO")
  }
}
