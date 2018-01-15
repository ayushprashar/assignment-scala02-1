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
superEncoding(List(1,1,1,1,1,2,2,2,2,2,4))