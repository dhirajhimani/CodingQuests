package toptal

object BeadCount extends App {

  println(solution(Array(5,4,0,3,1,6,2)))

  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    if(a.isEmpty) 0
    var max = -1
    val visited:Array[Boolean] = Array.fill[Boolean](a.length)(false)
    for(i <- 0 until a.length) {
      val beadLength: Int = findBeadLength(i, a, visited, 0)
      if ( beadLength > max) {
        max = beadLength
      }
    }
    max
  }


  def findBeadLength(i: Int, a: Array[Int], visited: Array[Boolean], beadLength: Int): Int = {
    if(!visited(i)) {
      visited(i) = true
      findBeadLength(a(i), a, visited, beadLength + 1)
    } else
      beadLength
  }


}
