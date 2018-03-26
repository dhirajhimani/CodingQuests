package hackerrank.functionalprogramming

// https://www.hackerrank.com/challenges/super-digit/problem

object SuperDigit extends App {

  val bi = scala.io.StdIn.readLine().split(" ")
  var superDigitS1 = BigInt(bi(0))
  var superDigitS2 = bi(1).toInt

  def calcSuperDigit(sDL1: BigInt): Long = {
    var sDL = sDL1
    while (sDL.toString.length > 1) {
      sDL = sDL.toString.foldLeft(0L)((acc, i) => acc + i.asDigit)
    }
    sDL.toLong
  }

  println(calcSuperDigit(calcSuperDigit(superDigitS1) * superDigitS2))
}
