package hackerearth.codearena

object CodeArena2 extends App {

  var N: Int = scala.io.StdIn.readLine().trim.toInt

  val A: Array[Int] = scala.io.StdIn.readLine().trim.split(" ").map(_.toInt)

  val B: Array[Int] = new Array[Int](N)

  val Q = scala.io.StdIn.readLine().trim.toInt

  recalculate()

  val tupleList = 1.to(Q).map(x => {
    scala.io.StdIn.readLine().trim.split(" ").map(_.toInt) match {
      case s: Array[Int] if (s(0) == 0) => {
        A(s(1) - 1) = s(2)
        recalculate()
      }
      case s: Array[Int] => {
        println(B(s(1) - 1))
      }
    }
  })

  def recalculate(): Unit = {
    var total: Int = 1;
    for (i <- 0 until N) {
      total = A(i) * total
    }
    //    for (i <- 0 until N) {
    ////      B(i) = total / A(i)
    //      B(i) = divide(total, A(i))
    //    }

    for (i <- 0 until N) {
      B(i) = 1
      for (j <- 0 until N) {
        if (i != j) {
          B(i) = B(i) * A(j);
        }

      }
    }
  }

  //  def divide(dividend: Int, divisor: Int): Int = {
  //    var div = dividend
  //    var quotient = 0
  //    while (div >= divisor) {
  //      div = div - divisor
  //      quotient = quotient + 1
  //    }
  //    quotient
  //  }

}
