package hackerrank.challenges.w37

object DynamicLineIntersection1 extends App {

  dynamicLineIntersection(4)

  case class Line(m:Int, c:Int)
  case class Plane(linesAdded: List[Line], linesRemoved: List[Line]) {

    def addLine(line: String): Plane = {
      Plane(linesAdded :+ getLine(line), linesRemoved)
    }

    def removeLine(line: String): Plane = {
      Plane(linesAdded, linesRemoved :+ getLine(line))
    }

    def getLine(line: String): Line = {
      val arg = line.split(" ")
      Line(arg(1).toInt, arg(2).toInt)
    }

    def getIntersections(line: String): Int = {
      val lineArguments = line.split(" ")
      val q = lineArguments(1).toInt
      var lineAdded = 0
        linesAdded.foreach(line => if (intersectAtIntPoint(line, q)) lineAdded += 1)
      var lineRemoved = 0
      linesRemoved.map(line => if (intersectAtIntPoint(line, q)) lineRemoved += 1 else 0)
      lineAdded - lineRemoved
    }

    def intersectAtIntPoint(line: Line, q: Int): Boolean = {
      val rem = (q - line.c) % line.m
      rem == 0
    }
  }

  def dynamicLineIntersection(n: Int): Unit = {
    var plane = Plane(List(), List())
    for(_ <- 1 to n) {
      val line = scala.io.StdIn.readLine.trim
      if (line.startsWith("+")) {
        plane = plane.addLine(line)
      } else if (line.startsWith("-")) {
        plane = plane.removeLine(line)
      } else {
        // query
        println(plane.getIntersections(line))
      }
//      println(plane)
    }
  }

}
