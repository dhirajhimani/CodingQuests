package hackerrank.algorithims.string

// https://www.hackerrank.com/challenges/strong-password/problem

object StrongPassword extends App {


  val numbers: String = "0123456789"
  val lower_case: String = "abcdefghijklmnopqrstuvwxyz"
  val upper_case: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val special_characters: String = "!@#$%^&*()-+"

  val sc = new java.util.Scanner (System.in);
  var n = sc.nextInt();
  var password = sc.next();
  val answer = minimumNumber(n, password);
  println(answer)



  def hasNumber(password: String): Boolean = {
    containsInArray(password, numbers.toCharArray)
  }

  def hasLowerCase(password: String) = containsInArray(password, lower_case.toCharArray)

  def hasUpperCase(password: String) = containsInArray(password, upper_case.toCharArray)

  def hasSpecialChars(password: String) = containsInArray(password, special_characters.toCharArray)


  def containsInArray(password: String, array: Array[Char]): Boolean = {
    var found = false
    password.foreach(c => {
      if (!found)
      found = array.contains(c)
    })
    found
  }
  def minimumNumber(n: Int, password: String): Int =  {
    if (n < 4) {
      6 - n
    } else {
      var count = 0
      if (!hasNumber(password)) {
        count += 1
      }
      if (!hasLowerCase(password)) {
        count += 1
      }
      if (!hasUpperCase(password)) {
        count += 1
      }
      if (!hasSpecialChars(password)) {
        count += 1
      }
      if (n + count < 6) {
        6 - n
      } else
        count
    }
  }
}
