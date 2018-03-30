package hackerrank.functionalprogramming

import java.io.{BufferedWriter, File, FileWriter}

object FractalTrees_1 extends App {

  import FractalTrees._

  printFractalTrees(5, 16)
}

object FractalTrees {
  case class Point(x: Int, y: Int)
  case class Branch(begin: Point, end: Point, size:Int)
  type Board = Array[Array[Char]]
  type Branches = Seq[Branch]
  type Points = Seq[Point]

  def printFractalTrees(iterations: Int, size: Int): Unit = {
    (
      get(aBasicPoint)              andThen
      splitBranch(iterations, size) andThen
      extractPointsFromBranches     andThen
      paintPointsOnBoard(newBoard)  andThen
      printBoard)()
  }

  private def get[T](t:T): Unit => T = _ => t

  private def aBasicPoint: Point = Point(x=63, y=49)

  private def newBoard: Board = Array.fill(63)(Array.fill(100)('_'))

  private def splitBranch(N:Int, size:Int): Point => Branches = { startingPoint =>
    val branches =  splitBranchToThreeSmallerBranches(size)(startingPoint)
    if (N <= 1) {
      branches
    } else {
        branches ++ branches.takeRight(2).flatMap({
          b => splitBranch(N - 1, size / 2)(getEndPointFromBranch(b))
        })
    }
  }

  private def getEndPointFromBranch(branch: Branch): Point = Point(branch.end.x, branch.end.y)

  private def splitBranchToThreeSmallerBranches(size: Int): Point => Branches = { p: Point =>
    Seq(
      Branch(Point(p.x, p.y), Point(p.x - size, p.y), size),
      Branch(Point(p.x - size, p.y), Point(p.x - 2 * size, p.y + size), size),
      Branch(Point(p.x - size, p.y), Point(p.x - 2 * size, p.y - size), size))
  }

  private def extractPointsFromBranches: Branches => Points =  _ flatMap getColoredPointsFromABranch

  private def getColoredPointsFromABranch(branch: Branch): Points = {
    val counter = if (branch.begin.y > branch.end.y) -1 else 1
    if (branch.begin.y == branch.end.y) {
      for {
        x <- (branch.end.x) until (branch.begin.x)
      } yield Point(x, branch.begin.y)
    } else {
      for {
        i <- 1 to branch.size
      } yield Point(branch.begin.x - i, branch.begin.y - i * counter)
    }
  }

  private def paintPointsOnBoard(board: Board) : Points => Board = { points: Points  =>
    points.foldLeft(board.clone()) { (mutatedBoard: Board, point: Point) =>
      mutatedBoard(point.x).update(point.y, '1')
      mutatedBoard
    }
  }

  private def printBoard: Board => Unit = {
    board =>
      val file = new File("TempFileToMatchChallengeArray.txt")
      val bw = new BufferedWriter(new FileWriter(file))
      for(row <- board) {
        val line = row.mkString
        println(line)
        bw.write(line + "\n")
      }
      bw.close()
  }

}


