package hackerrank.challenges.w37

// incomplete

object SuperiorCharacters extends App {

//  println(maximumSuperiorCharacters(Array(2, 1, 4, 1, 0, 2, 0, 3, 1, 2, 0, 3, 1, 1, 2, 0, 1, 4, 2, 3, 2, 3, 2, 0, 2, 1 )))

 println(maximumSuperiorCharacters2(Array(1, 2, 2, 3, 4, 0, 3, 4, 4, 1, 3, 1, 4, 4, 1, 0, 0, 0, 0, 0, 4, 2, 3, 2, 2, 1 )))

  def maximumSuperiorCharacters(freq: Array[Int]): Long = {
    val freqWithoutZero = freq.filter(_ !=0)
    def calc(index: Int, sum: Long, maxc: Long, carry: Long): Long = {
      if (index > 0) {
        val diff = carry - freqWithoutZero(index)
        if (diff >= 0) {
          calc(index -1, sum, maxc, diff)
        } else {
          calc(index -1, sum + maxc, math.abs(diff), math.abs(diff) * 2)
        }
      } else {
        val diff = freqWithoutZero(index) - carry
        if (diff <= 0){
          sum
        } else {
          (sum - (math ceil diff/2)).toLong
        }
      }

    }
    calc(freqWithoutZero.length - 2, 0, freqWithoutZero.last, freqWithoutZero.last * 2)
  }

  def maximumSuperiorCharacters2(freq: Array[Int]): Long = {
    val freqCh = freq.zipWithIndex.map(t => {
      val ch = (t._2 + 97).toChar
      ch.toString * t._1
    })
    val repeatCh = freqCh.mkString("");
    val superiorCh =  maximumSuperiorCharacters(repeatCh)
    println(superiorCh)
    0
  }

  def maximumSuperiorCharacters(repeatCh: String):String = {
    var rotateCh = repeatCh.toArray
    var rotationDone = false;

    while(!rotationDone) {
      for(i <- 0 to rotateCh.length - 2) {
        val last = rotateCh.last
        if (last > rotateCh(i) && last > rotateCh(i+1)) {
          for(j <- rotateCh.length - 1 to i+1 ) {
            rotateCh(j) = rotateCh(j - 1)
          }
          rotateCh(i + 1) = last
        } else{
          rotationDone = true
        }

      }
    }
    rotateCh.mkString
  }

}
