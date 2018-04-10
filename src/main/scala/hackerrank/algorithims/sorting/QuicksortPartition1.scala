package hackerrank.algorithims.sorting

//https://www.hackerrank.com/challenges/quicksort1/problem

object QuicksortPartition1 extends App {

  println(quickSort(Array(4,5,3,7,2)).mkString(" "))


  def quickSort(arr: Array[Int]): Array[Int] =  {
    val p = arr(0)
    val n = arr.length
    var index = 0
    for(i <- 1 to n - 1 ) {
      val key = arr(i)
      if (key < p) {
        var j = i - 1
        while (j >= 1 && arr(j) > key && j > index) {
          arr(j + 1) = arr(j)
          j = j - 1
        }
        arr(j + 1) = key
        index = j + 1
      }
    }
    var j = 1
    while (arr(j) < p) {
      arr(j-1) = arr(j)
      j += 1
    }
    arr(j - 1) = p
    arr
  }


}
