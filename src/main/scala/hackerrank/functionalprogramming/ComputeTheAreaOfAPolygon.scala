package hackerrank.functionalprogramming

object Solution3 extends App {

  var lines=io.Source.stdin.getLines()
  val nPoints= lines.next.toInt
  var points = lines.take(nPoints).toList map (s => s.split(" ")) map {case Array(e1,e2) => (e1.toDouble,e2.toDouble)}
  var X = points.map(x => x._1).toArray
  var Y = points.map(x => x._2).toArray

  println(polygonArea(X,Y,X.length))

  def polygonArea(X: Array[Double], Y: Array[Double], n: Int) = { // Initialze area
    var area = 0.0
    // Calculate value of shoelace formula
    var j = n - 1
    var i = 0
    while ( {
      i < n
    }) {
      area += (X(j) + X(i)) * (Y(j) - Y(i))
      j = i // j is previous vertex to i


      {
        i += 1; i - 1
      }
    }
    // Return absolute value
    Math.abs(area / 2.0)
  }
}

