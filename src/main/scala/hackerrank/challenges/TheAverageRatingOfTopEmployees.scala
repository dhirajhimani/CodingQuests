package hackerrank.challenges

// https://www.hackerrank.com/contests/w37/challenges/the-average-rating-of-top-employees

object TheAverageRatingOfTopEmployees extends App {

  averageOfTopEmployees(Array(10,20,30,50, 90, 91, 92, 93, 80))
  averageOfTopEmployees(Array(84,  92,  61,  50,  95))

  def averageOfTopEmployees(rating: Array[Int]): Unit = {

    val filteredEmployee = rating.filter(_>=90)
    val average = filteredEmployee.sum / filteredEmployee.size.toDouble
    val rounded = roundAt(2)(average)
    println(rounded)
    println(f"$rounded%1.2f")
  }

  def roundAt(p: Int)(n: Double): Double = { val s = math pow (10, p); (math round n * s) / s }
}
