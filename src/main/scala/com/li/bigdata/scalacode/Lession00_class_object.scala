package com.li.bigdata.scalacode

object Lession00 {

  var name="zhangsan"
//  private val t1:test1 = new test1()

  private val t1:test1 = new test1(1)

  println("hello word up")
  def main(args: Array[String]): Unit = {
    println("hello word")
    t1.printMsg()
  }

  println("hello word down")
}


// 类里 裸露的代码是默认构造中的  有默认构造
// 类名构造器里面的参数就是成员属性，默认是 val ，private
// 只有类名构造其中的参数可以设置为 var ，其他方法中的参数都是 val 类型，且不允许设置为var类型
class test1(sex:String){
  var name = "lisi"

  def this(xname:Int){
    // 定义的个性构造必须调用默认构造
    this("ascs")
  }

//  var 是变量
  var a=3
  a=4
//  val 是常量 不能修改
  val b=3
//  b=4
  println(s"hello word$a")

  def testooxx(ss:String): Unit ={
//    ss="1"  //普通方法中的参数为 val 类型，且不允许设置为 var 类型
    println(ss)
  }

  def printMsg(): Unit ={
    println(s"hello from test1 printMsg $sex")
  }

  println(s"hello word${a+4}")
}