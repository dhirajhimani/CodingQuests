package hackerrank.functionalprogramming

// https://www.hackerrank.com/challenges/rotate-string

object RotateString extends App {

//  val lines = io.Source.stdin.getLines().drop(1)
  val lines = List("abcd", "zxc")
  println(lines.map(
    x => x.scanLeft(x)(
      (t,_)=>t.tail + t.head).drop(1).mkString(" "))
    .mkString("\n"))

}
