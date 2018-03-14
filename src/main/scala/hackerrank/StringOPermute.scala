package hackerrank

object StringOPermute extends App {
  var lines = io.Source.stdin.getLines()

  val n = lines.next.toInt

  def permute(line: String):String = {
    if (line.length > 1) {
      line.charAt(1).toString + line.charAt(0).toString + permute(line.substring(2))
    } else {
      line
    }
//    line.sliding(2,2).toList.map(a=>a.reverse) mkString
  }
//  def swapString(s:String):String = {
//    def swapHelper(string:List[Char]):List[Char] = string match {
//      case Nil => Nil
//      case x::Nil => List(x)
//      case x :: y :: rest => y :: x :: swapHelper(rest)
//    }
//    swapHelper(s.toList).mkString("")
//  }

  for (_ <- 1.to(n)) {
    val line = lines.next.toString
    println(permute(line))
  }
}
