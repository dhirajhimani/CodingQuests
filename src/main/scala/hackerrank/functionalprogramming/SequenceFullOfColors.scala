package hackerrank.functionalprogramming

// https://www.hackerrank.com/challenges/sequence-full-of-colors/problem

object SequenceFullOfColors extends App {

  var N = scala.io.StdIn.readLine().toInt

  while (N > 0) {
    calcSequence(scala.io.StdIn.readLine())
    N -= 1
  }

  def calcSequence(str: String) = {
    //R,G,Y,B
    var validSeq = true
    var acc_seq = (0, 0, 0, 0)
    str.foldLeft(acc_seq)(
      (acc, x) => {
        acc_seq = acc
        x match {
          case 'R' => acc_seq = acc.copy(_1 = acc._1 + 1)
          case 'G' => acc_seq = acc.copy(_2 = acc._2 + 1)
          case 'Y' => acc_seq = acc.copy(_3 = acc._3 + 1)
          case 'B' => acc_seq = acc.copy(_4 = acc._4 + 1)
        }
//        println(acc_seq + " " + validSeq)
        // R-G
        if (
          validSeq
            &&
            (acc_seq._1 - acc_seq._2).abs < 2
            &&
            (acc_seq._3 - acc_seq._4).abs < 2
        ) {
          acc_seq
        } else {
          validSeq = false;
          acc_seq
        }
      })
    if (
      validSeq
        &&
        (acc_seq._1 == acc_seq._2)
        &&
        (acc_seq._3 == acc_seq._4)
    ) {
      println("True")
    } else {
      println("False")
    }
//    print(if(validSeq) "True\n" else "False\n")
  }
}
