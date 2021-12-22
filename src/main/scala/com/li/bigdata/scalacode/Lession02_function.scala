package com.li.bigdata.scalacode

import java.util.Date

/**
 * 函数
 */
object Lession02_function {
  def main(args: Array[String]): Unit = {

    // 没有返回值
    def fun01(){
      println("hello word")
    }
     var x = fun01()
    println(x)
    println("------------------------")

    // 有返回值
    def fun02():Int={
      return 2
    }
    var y = fun02()
    println(y)
    println("------------------------")

    // 参数
    def fun03(a:Int){
      println(a)
    }
    fun03(3)

    println("----------递归函数--------------")

    def fun04(num : Int): Int={
      if (num == 1){
        num
      } else {
        num * fun04(num -1)
      }
    }
    println(fun04(4))

    println("----------默认函数--------------")

    def fun05(a:Int=5,b:String="abc"){
      println(s"$a\t$b")
    }
    fun05()// 输出5 abc
    fun05(6,"bcd")// 输出6	bcd
    fun05(6)// 输出6 abc
    fun05(b="def")// 输出5 def

    println("----------匿名函数--------------")

    var w = (a:Int,b:String) => {
      a+b
    }
    val str = w(1, "2")
    println(str)

    // 匿名函数，类型表示方式
    var ww:(Int,Int) =>Int =(a:Int,b:Int) => {
      a+b
    }
    val yy = ww
    println(yy)

    println("----------嵌套函数--------------")

    def fun06(a:String): Unit ={
      def fun05(){
        println(a)
      }
      fun05()
      fun03(1)
    }
    fun06("hello")

    println("----------偏应用函数--------------")

    def fun07(dt:Date,tp:String,msg:String): Unit ={
      println(s"$dt\t$tp\t$msg")
    }
    fun07(new Date(),"info","ok")

    // 实现一个info的方法，赋值给变量
    var info = fun07(_:Date,"info",_:String)
    // 调用info 时，就只用传递 时间 和 消息 两个参数
    info(new Date(),"ok")

    println("----------可变参数函数--------------")

    def fun08(a:Int*): Unit ={
//      for (e <- a) {
//        println(e)
//      }
//def foreach[U](f: A => U): Unit
      a.foreach((x:Int) => {println(x)})
      a.foreach(println(_))
      a.foreach(println)
    }
    fun08(3)
    fun08(1,2,3)

    println("----------高阶函数--------------")
    // 函数作为参数
    // 实现一个计算器，传入两个参数，一个函数，得出结果
    def computer(a:Int, b:Int, f:(Int,Int)=>Int): Unit ={
      val req = f(a, b)
      println(req)
    }
    computer(3,8,(x:Int,y:Int)=>{x+y})
    computer(3,8,(x:Int,y:Int)=>{x*y})
    computer(3,8,_*_)

    // 函数作为返回值
    def factory(x:String): (Int,Int)=>Int ={
      def puls(a:Int,b:Int): Int ={
        a+b
      }
      def mult(a:Int,b:Int): Int ={
        a*b
      }
      if (x.equals("+")){
        puls
      } else{
        mult
      }
    }
    computer(3,4,factory("+"))

    println("----------柯里化-------------")

    def fun10(a:Int)(b:Int)(c:String): Unit ={
      println(s"$a\t$b\t$c")
    }
    fun10(1)(2)("dadas")

    def fun11(a:Int*)(b:Int*)(c:String*): Unit ={
      a.foreach(println)
      b.foreach(println)
      c.foreach(println)
    }
    fun11(1,2)(3,4)("asd","fdf")

    println("---------方法------------")

    // 成员方法，赋值给一个引用，会直接调用。如果不想执行  方法名+空格+下划线
    var oo = ooxx(1)
    var xx = ooxx _
  }

  def ooxx(a:Int): Unit ={
    println(s"hello word ooxx $a")
  }
}
