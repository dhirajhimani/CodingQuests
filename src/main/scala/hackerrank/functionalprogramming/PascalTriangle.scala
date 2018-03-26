package hackerrank.functionalprogramming

// https://www.hackerrank.com/challenges/pascals-triangle/problem

object Solution4 extends App {
  def factorial(i: Int): Int = {
    if (i < 2) {
      1
    } else {
      i * factorial(i-1)
    }
  }

  def calcPas(n: Int, r: Int) = {

    factorial(n) / (factorial(r) * factorial(n - r))
  }

  def printPas(k: Int) = {

    0.until(k).foreach(i => {0.to(i).foreach(j => print(calcPas(i, j) + " ")); println})

//    for (i <- 0.until(k)) {
//      for (j <- 0.to(i)) {
//        print(calcPas(i, j) + " ")
//      }
//      println("")
//    }
  }

  printPas(4)
}

