package hackerrank

// https://www.hackerrank.com/challenges/rotate-string

object RotateString extends App {

//  var T:Int = scala.io.StdIn.readLine().toInt
//  for(i <- 1.to(T)) {
//    rotate(scala.io.StdIn.readLine)
//    println
//  }
//
//  def rotate(str: String) = {
//    var rstr = str
//    for (_ <- 1.to(str.length)) { rstr = rstr.tail + rstr.head ; print(rstr +" ")}
//  }

  val lines = io.Source.stdin.getLines().drop(1)
  println(lines.map(
    x => x.scanLeft(x)(
      (t,_)=>t.tail + t.head).drop(1).mkString(" "))
    .mkString("\n"))

}
