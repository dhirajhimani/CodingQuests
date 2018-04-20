package hackerrank.challenges.w37

object DynamicLineIntersection extends App {

  dynamicLineIntersection(4)

  case class Line(m:Int, c:Int)
  case class Plane(var lines: List[Line]) {

    def addLine(line: String) = {
      val lineArguments = line.split(" ")
      Plane(lines = lines :+ Line(lineArguments(1).toInt, lineArguments(2).toInt))
    }

    def removeLine(line: String): Plane = {
      val lineArguments = line.split(" ")
      val lineToRemove = Line(lineArguments(1).toInt, lineArguments(2).toInt)
      Plane(lines.filterNot(_ equals lineToRemove))
    }

    def getIntersections(line: String): Int = {
      val lineArguments = line.split(" ")
      val q = lineArguments(1).toInt
      lines.map(line => if (intersectAtIntPoint(line, q)) 1 else 0).sum
    }

    def intersectAtIntPoint(line: Line, q: Int): Boolean = {
      val rem = (q - line.c) % line.m
      rem == 0
    }
  }

  def dynamicLineIntersection(n: Int): Unit = {
    var plane = Plane(List())
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
