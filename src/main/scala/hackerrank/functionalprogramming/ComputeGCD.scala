package hackerrank.functionalprogramming

object ComputeGCD extends App {
  def gcd(x: Int, y: Int): Int = {
    // You only need to fill up this function
    // To return the value of the GCD of x and y
    var rem = 0;
    if (x == y) {
      x
    } else if (x > y) {
      if (x % y == 0) {
        y
      }
      gcd(y, x % y)

    } else {
      if (y % x == 0) {
        x
      }
      gcd(x, y % x)
    }
  }


  /** This part handles the input/output. Do not change or modify it **/
  def acceptInputAndComputeGCD(pair: List[Int]) = {
    println(gcd(pair.head, pair.reverse.head))
  }

  acceptInputAndComputeGCD(readLine().trim().split(" ").map(x => x.toInt).toList)
}
