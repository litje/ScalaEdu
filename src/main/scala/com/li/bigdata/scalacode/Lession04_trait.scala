package com.li.bigdata.scalacode

/**
 * Trait 多继承
 */
trait God {
  def say(): Unit ={
    println("God Say ...")
  }
  // 未实现的方法，需要继承类具体实现
  def cry(): Unit
}

trait Devil {
  def call(): Unit ={
    println("Devil Call ...")
  }
}

class Person(name:String) extends God with Devil{
  def hello(): Unit ={
    println(s"$name say")
  }
  // 实现 God类中的方法
  override def cry(): Unit = {
    println("Person Cry ...")
  }
}

object Lession04_trait {
  def main(args: Array[String]): Unit = {
    // p 的类型可以为 Person、God、Devil，如果为父类的类型只能调用父类自己的方法
    val p = new Person("zhangsan")
    p.hello()
    p.say()
    p.call()
  }
}

