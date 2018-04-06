package hackerrank.algorithims.string

object HackerRankInAString extends App {

  assert(hackerrankInString("hereiamstackerrank") == "YES")

  def hackerrankInString(s: String): String =  {
    val containgString  = "hackerrank"
    var reducedString = s
    var contains = true;
    for(c <- containgString if (contains)) {
      val index = reducedString.indexOf(c.toString)
      if (index == -1) {
        contains = false
      }
      reducedString = reducedString.substring(index+1)
    }

    if (contains) "YES" else "NO"
  }


}
