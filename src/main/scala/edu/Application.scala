package edu
import org.apache.log4j.Logger
object Application extends App {

  val log = Logger.getLogger(this.getClass)
  val rotationListElement1: Int = 5
  val rotationListElement2: Int = 6
  val rotationListElement3: Int = 4
  val rotationListElement4: Int = 9
  val rotationList: List[Int] = List(rotationListElement1,rotationListElement2,rotationListElement3,rotationListElement4)
  val shiftIndex: Int = 3

  log.info(s"${Operations.shiftLeft(rotationList,shiftIndex)} \n")

  val happyNumberElement1: Int = 19
  val happyNumberElement2: Int = 20
  val happyNumberElement3: Int = 7
  val happyNumberElement4: Int = 29
  val happyNumberList: List[Int] = List(happyNumberElement1,happyNumberElement2,happyNumberElement3,happyNumberElement4)

  log.info(s"${Operations.happyNumber(happyNumberList)} \n")

  val consecutiveDuplicateElement1: Int = 1
  val consecutiveDuplicateElement2: Int = 1
  val consecutiveDuplicateElement3: Int = 1
  val consecutiveDuplicateElement4: Int = 2
  val consecutiveDuplicateElement5: Int = 2
  val consecutiveDuplicateElement6: Int = 2
  val consecutiveDuplicateElement7: Int = 1
  val consecutiveDuplicateList:List[Int] = List(consecutiveDuplicateElement1
    ,consecutiveDuplicateElement2,consecutiveDuplicateElement3,consecutiveDuplicateElement4,
    consecutiveDuplicateElement5,consecutiveDuplicateElement6,consecutiveDuplicateElement7)

  log.info(s"${Operations.removeDuplicates(consecutiveDuplicateList)}")
}
