package hackerrank

object FunctionalHelpers {
  def repeat[T](f: T=>T, times: Int)(start:T): T = {
    if (times == 0) start
    else repeat(f, times -1)(f(start))
  }
  def get[T](t:T): Unit => T = _ => t

  def getAndPrint[T](t:T): Unit => T = _ => {println(t); t}
  def getAndPrint2[T](): T => T = t => {println(t); t}
}
