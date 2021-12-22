package com.li.bigdata.scalacode

/**
 * 偏函数
 */
object Lession07_PartialFunction {
  def main(args: Array[String]): Unit = {

    def xxx:PartialFunction[Any,String] = {
      case x:Int => s"$x is Int"
      case "hello" => "val is hello"
      case _=> "none"
    }

    println(xxx(1))
    println(xxx(1.0))
    println(xxx("hello"))

  }

}
