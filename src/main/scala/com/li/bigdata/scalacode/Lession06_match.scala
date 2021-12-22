package com.li.bigdata.scalacode

/**
 * match 相当于 Java中的switch
 */
object Lession06_match {
  def main(args: Array[String]): Unit = {
    // 遍历每一个类型，并打印一句话
    val tup: (Double, String, Int, Boolean, Char) = (1.0, "abc", 2, false, 'a')
    val ite: Iterator[Any] = tup.productIterator
    ite.foreach {x=>{x match {
      case x: Char => println(s"$x is Char")
      case "abc" => println("is abc")
      case x: Int => if (x>1) {println(s"$x is > 1")}
      case x: Char => println(s"$x is Char")
      case x: Boolean => println(s"$x is Boolean")
      case _:Any => println("is not type")
    }}
    }
  }
}
