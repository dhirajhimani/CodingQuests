package hackerrank.functionalprogramming

object SierpinskiTriangle extends App {

  def printTriangle(n:Int) {
    val total_r = 32
    val total_c = 63
    val total_tri = Math.pow(2,n)
    val smallest_tri_r:Int = (total_r/total_tri).toInt
    val smallest_tri_c:Int = (total_c/total_tri).toInt
    println("smallest_tri_r " + smallest_tri_r)
    println("smallest_tri_c " + smallest_tri_c)
    startPrinting(total_r: Int,total_c: Int, smallest_tri_r: Int, smallest_tri_c: Int)
  }

  def startPrinting(total_r: Int, total_c: Int, smallest_tri_r: Int, smallest_tri_c: Int) = {
    for(i <- 0.until(total_r)) {
      val total_1 = 2*i+ 1
      val start_pos = (total_c-total_1)/2
      for(j <- 0.to(total_c - total_1)) {
        printTriangle(j, total_1, start_pos)
      }
      println()
    }
  }

  def printTriangle(cursor_pos: Int, total_1: Int, start_pos: Int) = {
    if(cursor_pos == start_pos) {
     for(i <- 1.to(total_1)){ print("1") }
    } else{
      print("_")
    }
  }

//  printTriangle(0)
  printTriangle(1)
//  printTriangle(2)
//  printTriangle(3)
//  printTriangle(4)
}
