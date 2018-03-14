package hackerrank

// https://www.hackerrank.com/challenges/prefix-compression/problem

object PrefixCompression extends App {

  val x = scala.io.StdIn.readLine()
  val y = scala.io.StdIn.readLine()

  computePrefix(x,y)

  def computePrefix(x: String, y: String) = {
    var first_matches = true
    val prefix = x.zip(y).collect({
      case (x1,y1) if first_matches =>
        if(x1 == y1 && first_matches) x1 else first_matches = false
    }).map({
      case () => ""
      case (x) => x
    }).mkString
    val len = prefix.length
    println(len + " " + prefix)
    val p_x = x.substring(len)
    val p_y = y.substring(len)

    println(p_x.length + " " + p_x)
    println(p_y.length + " " + p_y)
  }
}
