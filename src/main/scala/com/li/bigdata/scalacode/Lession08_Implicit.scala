package com.li.bigdata.scalacode

import java.util
import scala.language.implicitConversions

/**
 * 隐式转换
 * 使 Java 的某些类可以使用 Scala 的方法
 */
object Lession08_Implicit {
  def main(args: Array[String]): Unit = {
    val linked = new util.LinkedList[Int]()
    linked.add(1)
    linked.add(2)
    linked.add(3)

    // 定义一个foreach 函数，传入需要遍历的集合 以及 对应要执行的函数
    // 人为定义方法
    def foreach[T](linkedList: util.LinkedList[T], f:T => Unit): Unit ={
      val it = linkedList.iterator()
      while (it.hasNext) f(it.next())
    }
    foreach(linked,println)

    // 定义一个类 简化上述代码
    val value = new xxx[Int](linked)
    value.foreach(println)

    // 使用implicit 可以简化上述代码, 隐式转换方法 方法名可以任意
    implicit def dsf[T](list1:util.LinkedList[T]): xxx[T] ={
      new xxx[T](list1)
    }
    // 隐式转换类
//    implicit class kkk[T](ts: util.LinkedList[T]) {
//      def foreach(f:T => Unit): Unit ={
//        val it = ts.iterator()
//        while (it.hasNext) f(it.next())
//      }
//    }
    // listed对象中没有foreach 方法，Java语法中会报错，这些代码会交给Scala 编译器
    /**
     * 1.Scala 发现 listed 没有foreach()
     * 2.去寻找有没有 implicit 定义的方法，且方法的参数正好是 List的类型
     * 3.编译器会帮你把代码修改
     */
    linked.foreach(println)

    // 隐式转换参数
    /**
     * 1、def sss(implicit name:String,age:Int)
     *   调用时 sss("zhangsan",1) 或者 sss 但上面需要定义全部参数 implicit val xx
     * 2、def sss(name:String)(implicit age:Int) 柯里化定义时，implicit修饰参数必须放在后面
     *  调用时 sss("zhangsan") 或者 sss("zhangsan")上面定义implicit val xx 或者 sss("zhangsan",1) 或者 sss上面定义implicit val xx
     */
    implicit val name:String = "lisi"
    implicit val ag:Int = 1
    def sss(implicit name:String,age:Int): Unit ={
      println(name,age)
    }
    sss("zhangsan",1)
    sss
  }
}

class xxx[T](ts: util.LinkedList[T]){
  def foreach(f:T => Unit): Unit ={
    val it = ts.iterator()
    while (it.hasNext) f(it.next())
  }
}