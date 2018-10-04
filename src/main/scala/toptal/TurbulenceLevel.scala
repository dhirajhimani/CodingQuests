package toptal

object TurbulenceLevel extends App {


  println(solution(Array(9, 4, 2, 107, 8, 8, 1, 9)))
  println(solution(Array(4,8,12,16)))


  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    val UP :Int = 0
    val DOWN :Int = 1
    val LEVEL :Int= 2

    var expecting = LEVEL


    def expectedTurbulence(i: Int, j: Int): Int = {
      if (i > j) {
        UP
      } else if (i < j) {
        DOWN
      } else {
        LEVEL
      }
    }

    var i = 0
    var max: Int = 1
    val length = a.length
    if (length == 1) {
      max
    } else {
      expecting = expectedTurbulence(a(i), a(i + 1))
      i = 1
      var turbulenceLevel = 1
      while (i < length - 1) {

        if (expecting == LEVEL) {
          turbulenceLevel = 1
          i = i + 1
        } else {
          if (a(i) > a(i + 1) && expecting == DOWN) {
            turbulenceLevel = turbulenceLevel + 1
            i = i + 1
            expecting = UP
          } else if (a(i) < a(i + 1) && expecting == UP) {
            turbulenceLevel = turbulenceLevel + 1
            i = i + 1
            expecting = DOWN
          } else {
            turbulenceLevel = 1
            expecting = expectedTurbulence(a(i), a(i + 1))
            i = i + 1
          }
          if (turbulenceLevel > max) {
            max = turbulenceLevel
          }
        }

      }
      max + 1
    }
  }
}
