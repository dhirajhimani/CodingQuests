package hackerrank.functionalprogramming

//https://www.hackerrank.com/challenges/lambda-march-compute-the-perimeter-of-a-polygon/problem

//4
//0 0
//0 1
//1 1
//1 0

object Solution2 extends App {

  var N: Int = scala.io.StdIn.readLine().trim.toInt
  val tupleList = 1.to(N).map(x => {
    scala.io.StdIn.readLine().trim.split(" ") match {
      case Array(str1, str2) => (str1, str2)
    }
  }).toList
//  println(tupleList)
  var sum:Double = 0
  for(i <- 0.until(tupleList.size)) {
    var n = i + 1
    if (i == tupleList.size - 1) {
      n = 0
    }
    val (x1,y1) = tupleList(i)
    val (x2,y2) = tupleList(n)

    var xy = Math.pow(x2.toDouble - x1.toDouble, 2) + Math.pow(y2.toDouble - y1.toDouble, 2)

    sum += Math.sqrt(xy)

  }
  println(sum)


  // Read This
//  def distance(p1:(Int,Int),p2:(Int,Int)): Double =
//    math.sqrt(math.pow(p1._1-p2._1,2)+math.pow(p1._2-p2._2,2))
//
//  var lines=io.Source.stdin.getLines()
//
//  val nPoints= lines.next.toInt
//  var points = lines.take(nPoints).toList map (s => s.split(" ")) map {case Array(e1,e2) => (e1.toInt,e2.toInt)}
//
//  var polygLine = points :+ points.head
//
//  var perimeter= (polygLine.tail.foldLeft((0.0,polygLine.head)){case (acc,p)=> (acc._1+distance(acc._2,p),p)})._1
//
//  println(perimeter)
}
