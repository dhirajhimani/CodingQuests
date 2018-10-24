package hackerearth.codearena

object CodeArena6 extends App {

  val T = scala.io.StdIn.readLine().trim.toInt

  for (i <- 1 to T) {
    val N_Q = scala.io.StdIn.readLine().trim.split(" ").map(_.toInt)

    val A = scala.io.StdIn.readLine().trim.split(" ").map(_.toInt)

    val Q = N_Q(1)

    for (j <- 1 to Q) {
      scala.io.StdIn.readLine().trim.split(" ").map(_.toInt) match {
        case a => {
          if (a(0) == 1) {
            A(a(1) - 1) = A(a(1) - 1) + a(2)
          } else {
            lenOfLongIncSubArr(A.slice(a(1) - 1, a(2)))
          }
        }
      }
    }

    // extra array required(O(N + Size))
    def lengthOfLIS(nums: Array[Int]) {
      println(nums.mkString(" "))

      val maxA = new Array[Int](nums.length)
      maxA(0) = 0
      var max = 0

      for (i <- 1 until nums.length) {
        if (nums(i - 1) < nums(i)) {
          maxA(i) = maxA(i - 1) + 1
        } else {
          maxA(i) = 0
        }
      }
      println(maxA.max + 1)
    }


    // Still preferred to above soln, but still getting overflow time for 50% cases
    def lenOfLongIncSubArr(arr: Array[Int]) {
      var max = 1
      var len = 1

      for (i <- 1 until arr.size) {
        if (arr(i) > arr(i - 1))
          len = len + 1
        else {
          if (max < len)
            max = len

          len = 1
        }
      }
      if (max < len)
        max = len

      println(max)
    }

  }
}