
def removeDuplicates(domain: List[Int]) : List[Int] = {
  def consecutiveElemination(inputList: List[Int], uniqueList: List[Int], currentElement: Int): List[Int] = {
    inputList match {
      case head :: Nil if head == currentElement => uniqueList
      case head :: Nil if head != currentElement => uniqueList :+ head
      case head :: tail if head == currentElement => consecutiveElemination(tail, uniqueList, currentElement)
      case head :: tail if head != currentElement => consecutiveElemination(tail, uniqueList :+ head, head)
      case Nil => List()
    }
  }

  consecutiveElemination(domain,List(),-1)
}

removeDuplicates(List(1,1,1,1,1,2,2,2,2,2,2,4,2,2,2,5,5))
/*//HappyNumber(List(1,2,3,4))
//mainHappyCheck(List(1,2)," ")





/*
*/

//checkHappyNumber(20,20,List())
//squareSum(552,0)*/
