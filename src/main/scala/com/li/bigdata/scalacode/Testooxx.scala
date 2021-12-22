package com.li.bigdata.scalacode

object Testooxx{

  private val testooxx = new Testooxx()
  private var name = "lisi"
  def main(args: Array[String]): Unit = {
    println("hello xxoo")
    testooxx.printMsg()
  }

}

class Testooxx{
  var name= "zhangsan"

  def printMsg(): Unit ={
    println(Testooxx.name)
  }
}