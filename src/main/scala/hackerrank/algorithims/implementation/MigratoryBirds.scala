package hackerrank.algorithims.implementation

import scala.collection.mutable

// https://www.hackerrank.com/challenges/migratory-birds/problem

object MigratoryBirds extends App {


  val sc = new java.util.Scanner(System.in);
  var n = sc.nextInt();
  var ar = new Array[Int](n);
  for (ar_i <- 0 to n - 1) {
    ar(ar_i) = sc.nextInt();
  }
  val birdMap = mutable.HashMap[Int, Int]()
  ar.foreach(
    b => {
      birdMap += b -> (birdMap.getOrElse(b, 0) + 1)
    }
  )
  println(birdMap.toSeq.sortWith(
    (kv1, kv2) => {
      if (kv1._2 == kv2._2)
        kv1._1 < kv2._1
      else
        kv1._2 > kv2._2
    }
  ))

  println(birdMap.toSeq.sortWith(
    (kv1, kv2) => {
      if (kv1._2 == kv2._2)
        kv1._1 < kv2._1
      else
        kv1._2 > kv2._2
    }
  )(0)._1)

}
