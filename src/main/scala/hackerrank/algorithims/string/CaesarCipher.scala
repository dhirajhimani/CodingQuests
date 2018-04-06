package hackerrank.algorithims.string

object CaesarCipher extends App {

  assert(caesarCipher2("middle-Outz", 2) == "okffng-Qwvb") // okffng-Qwvb
  assert(caesarCipher2("www.abc.xy", 87) == "fff.jkl.gh") // fff.jkl.gh

  def caesarCipher(s: String, k: Int): String =  {
    var decrypted = ""
    for(c <- s.toCharArray) {
      if (c >= 65 && c <= 90) {
        var c1 = c - 65
        c1 += k
        c1 = c1 % 26
        c1 += 65
        decrypted += c1.toChar
      }
      else if (c >= 97 && c <= 122) {

        var c1 = c - 97
        c1 += k
        c1 = c1 % 26
        c1 += 97
        decrypted += c1.toChar
      }
      else
        decrypted += c.toChar
    }
    decrypted
  }


  def caesarCipher2(s: String, k: Int): String =  {
    var decrypted = ""
    for(c <- s.toCharArray) {
      if(c.isLetter) {
        var a = if (c.isUpper) 'A' else 'a'
        decrypted += (a + (c - a  + k)%26).toChar
      } else
        decrypted += c.toChar
    }
    decrypted
  }


}
