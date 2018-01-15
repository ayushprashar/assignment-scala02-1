package edu

object Operations {

  def shiftLeft(domain: List[Int], counter: Int): List[Int] = {
    if (counter == 0) {
      domain
    }
    else {
      domain match {
        case Nil => List()
        case _ :: Nil => domain
        case head :: tail => shiftLeft(tail :+ head, counter - 1)
      }
    }
  }

  def squareSum(input: Int, sum: Int): Int = {
    if (input < 10) {
      (input * input) + sum
    }
    else {
      squareSum(input / 10, sum + (input % 10) * (input % 10))
    }
  }

  def happyNumber(inputList: List[Int]): String = {
    mainHappyCheck(inputList, " ")
  }

  def removeDuplicates(domain: List[Int]): List[Int] = {
    def consecutiveElemination(inputList: List[Int], uniqueList: List[Int], currentElement: Int): List[Int] = {
      inputList match {
        case head :: Nil if head == currentElement => uniqueList
        case head :: Nil if head != currentElement => uniqueList :+ head
        case head :: tail if head == currentElement => consecutiveElemination(tail, uniqueList, currentElement)
        case head :: tail if head != currentElement => consecutiveElemination(tail, uniqueList :+ head, head)
        case Nil => List()
      }
    }

    consecutiveElemination(domain, List(), -1)
  }

  private def checkHappyNumber(originalInput: Int, mainInput: Int, visited: List[Int]): String = {

    def squareSum(input: Int, sum: Int): Int = {
      if (input < 10) {
        (input * input) + sum
      }
      else {
        squareSum(input / 10, sum + (input % 10) * (input % 10))
      }
    }

    def checkExistence(toFind: Int, domain: List[Int]): Boolean = {
      def subCheckExistence(newDomain: List[Int], flag: Int): Int = {
        newDomain match {
          case head :: Nil if head != toFind => -1
          case head :: tail if head != toFind => subCheckExistence(tail, flag)
          case head :: _ if head == toFind => flag
          case _ => -1
        }
      }

      if (subCheckExistence(domain, 0) == 0) {
        true
      }
      else {
        false
      }
    }

    val squaredSum = squareSum(mainInput, 0)
    if (squaredSum == 1) {
      s"Yes $originalInput is a happy number \n"
    }
    else {
      if (checkExistence(squaredSum, visited)) {
        s"No $originalInput is not a happy number \n"
      }
      else {
        checkHappyNumber(originalInput, squareSum(squaredSum, 0), visited :+ squaredSum)
      }
    }
  }

  private def mainHappyCheck(inputDomain: List[Int], resultString: String): String = {


    inputDomain match {
      case head :: Nil => s"$resultString ${checkHappyNumber(head, head, List())}"
      case head :: tail => mainHappyCheck(tail, s"$resultString ${checkHappyNumber(head, head, List())}")
      case Nil => "Empty Domain"
    }
  }
  def superEncoding(originalDomain: List[Int]):List[(Int,Int)] = {
    def encoding(domain: List[Int], result: List[(Int, Int)], currentElement: Int, count: Int): List[(Int, Int)] = {
      domain match {
        case head :: Nil if head == currentElement => result ::: List((currentElement, count + 1))
        case head :: Nil if head != currentElement => result ::: List((currentElement, count)) ::: List((head, 1))
        case head :: tail if head == currentElement => encoding(tail, result, head, count + 1)
        case head :: tail if head != currentElement => {
          encoding(tail, result ::: List((currentElement, count)), head, 1)
        }
      }
    }
    encoding(originalDomain,List(),-1,0)
  }
}
