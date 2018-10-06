package toptal

object DominoLongestChain extends App {

//  println(domino("3-2,2-1,1-4,4-4,5-4,4-2,2-1"))
//  println(domino("3-2,2-1,1-4,4-4,5-4,4-2,2-1, 3-2,2-1,1-4,4-4,4-4,4-4"))

  domino("1-1") // 1
  domino("1-2,1-2") // 1
  domino("3-2,2-1,1-4,4-4,5-4,4-2,2-1") // 4
  domino("5-5,5-5,4-4,5-5,5-5,5-5,5-5,5-5,5-5,5-5") // 7
  domino("1-1,3-5,5-5,5-4,4-2,1-3") // 4
  domino("1-2,2-2,3-3,3-4,4-5,1-1,1-2") // 3

  def domino(str: String): Int = {
      val list: Array[String] = str.split(",")
    var count = 1
    var max = 0
    for(i <- 0 to list.length-2) {
      val elem = list(i)
      val next  = list(i+1)
      if(elem(2) == next(0)){
        count = count + 1
      } else {
        if(count > max) {
          max = count
        }
        count = 1
      }
    }
    if(count > max) {
      max = count
    }
    println(max)
    max
  }

}
