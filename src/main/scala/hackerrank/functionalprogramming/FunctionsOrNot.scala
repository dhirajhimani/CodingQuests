package hackerrank.functionalprogramming

//https://www.hackerrank.com/challenges/functions-or-not/problem

object Solution1 extends App {


  //  var T: Int = scala.io.StdIn.readLine().trim.toInt
  //  for (i <- 1.to(T)) {
  //    var N: Int = scala.io.StdIn.readLine().trim.toInt
  //    val list = 1.to(N).map(x => scala.io.StdIn.readLine().trim.split(" ")(0).toInt).toList
  //    if (list.distinct.size == list.size) {
  //      println("YES")
  //    } else {
  //      println("NO")
  //    }
  //  }
  var T: Int = scala.io.StdIn.readLine().trim.toInt
  for (i <- 1.to(T)) {
    var N: Int = scala.io.StdIn.readLine().trim.toInt
    var set = scala.collection.mutable.Set[Int]()
    var invalid = false
    for (j <- 1.to(N)) {
      var (x, y) = scala.io.StdIn.readLine().trim.split(" ") match {
        case Array(str1, str2) => (str1, str2)
      }
      if (!invalid && !set.add(x.toInt)) {
        invalid = true
      }
    }
    if (invalid) {
      println("NO")
    } else {
      println("YES")
    }
  }
}

