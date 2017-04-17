package recfun

object Main {

  def main(args: Array[String]) {
    println("Pascal's Triangle")

    for (row <- 0 to 5) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c <= 0 || c >= r) 1 //pascal trial always has ones on the sides
    else {
      val prevR = r - 1 //calculate once
      pascal(c, prevR) + pascal(c - 1, prevR) //pascal's triangle depends on the row above
    }

  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean =  {

    def balanceAcc(chars: List[Char], acc: Int): Int = {
      if (chars.isEmpty || acc < 0) acc
      else if (chars.head == '(') balanceAcc(chars.tail, acc + 1)
      else if (chars.head == ')') balanceAcc(chars.tail, acc - 1)
      else balanceAcc(chars.tail, acc)
    }

    balanceAcc(chars, 0) == 0 //move through string character by character starting at beginning
  }


  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int =  {

    if (money == 0) 1 //return 1 when there is no money (only one way to calculate)
    else if (money < 0 || coins.isEmpty) 0 //no money or no coins results in 0 possibilities
    else if (money <= 0 && coins.isEmpty) 0 //no money and coins results in 0 possibilities
    else countChange(money, coins.tail) + countChange(money - coins.head, coins) //use recursion to iterate down
  }

}
