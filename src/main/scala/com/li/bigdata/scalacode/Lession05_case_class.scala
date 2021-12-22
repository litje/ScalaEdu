package com.li.bigdata.scalacode

/**
 * 样例类 case class
 */
object Lession05_case_class {
  def main(args: Array[String]): Unit = {
    val dog1 = new Dog("哈士奇", 18)
    val dog2 = new Dog("哈士奇", 18)
    println(dog1.equals(dog2)) // false
    println(dog1 == dog2) // false

    // case class new可以省略
    val cat1 = new Cat("英短", 18)
    val cat2 = new Cat("英短", 18)
    println(cat1.equals(cat2)) // true
    println(cat1 == cat2) // true
  }
}

class Dog(name:String,age:Int){
}

case class Cat(name:String,age:Int){
}