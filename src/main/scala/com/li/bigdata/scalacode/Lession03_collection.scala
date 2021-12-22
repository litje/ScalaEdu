package com.li.bigdata.scalacode

import java.util
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * 集合容器
 */
object Lession03_collection {
  def main(args: Array[String]): Unit = {

    println("------------Java本身--------------")

    //使用Java 的 collections
    val linkedList = new util.LinkedList[String]()
    linkedList.add("String")

    println("------------数组------------------")

    // scala 自己的collections
    // val 约等于 final ，不可变描述的时val指定的引用的值（值：字面值、地址）
    val array = Array[Int](1, 2, 3, 4)
    println(array(1))
    array(1)=99
    println(array(1))
    array.foreach(println)

    println("-------------链表-----------------")

    // Scala 中有两个包：immutable(不可变)、mutable(可变)，默认是不可变的
    // 链表顺序是输入顺序，可以重复
    // 不可变的
    val list01 = List(1, 2, 3, 2)
    list01.foreach(println)

    // 可变的
    val listBuffer = new ListBuffer[Int]()
//    listBuffer.append(33)
    listBuffer.+=(33,34,32)
    listBuffer.+=:(35) // 在链表头添加元素
    listBuffer.-=(35) // 从链表中删除指定元素
//    val str = listBuffer.+("zhangsan")
//    println(str)  //输出 ListBuffer(33, 34)zhangsan
    listBuffer.foreach(println)

    println("-------------Set-----------------")
    val set01 = Set(2, 3, 2, 1)
    set01.foreach(println)
    val set02 = mutable.Set(11, 22, 44, 22, 33)
    set02.add(88)
    set02.foreach(println)

    val set03 = scala.collection.immutable.Set(99, 88, 77)
    set03.foreach(println)

    println("-------------Tuple-----------------")
    val t2 = Tuple2(1, "sfsf")
    val t4 = Tuple4((a:Int,b:Int)=>{a+b}, 3,(a:Int)=>{a+8},4)
    // 取单个元素
    println(t2._2)
    println(t4._3)  // 输出 <function1> function表示函数，1表示一个参数
    println(t4._1(2, 3))  // 输出函数结果 5

    val ite = t2.productIterator
    while (ite.hasNext) {
      println(ite.next())
    }

    println("-------------Map-----------------")

    // 不可变
    val map01 = Map(("a", 33), "b" -> 22, ("a", 44))
    map01.foreach(println)  // 输出 (a,44) (b,22)
    /**
     * option: None  Some
     * None: 表示无值
     * Some: 表示有值
     */
    println(map01.get("a"))  // 输出 Some(44)
    println(map01.get("c"))  // 输出 None
    println(map01.get("a").getOrElse())  // 输出 44
    println(map01.get("c").getOrElse())  // 输出 ()

    val keysMap = map01.keys
    for (elem <- keysMap) {
      println(s"key: $elem  value: ${map01(elem)}")
    }

    // 可变Map
    val map02 = scala.collection.mutable.Map(("a", 1), ("b", 2))
    map02.put("c",3)

    println("--------------艺术----------------")

    val list = List(1, 2, 3, 4)
    val listMap = list.map((a: Int)=>{a + 10})
    listMap.foreach(println)  // 11 12 13 14
    list.foreach(println) // 1 2 3 4

    println("--------------艺术 升华----------------")
    // 需求：把字符串根据 空格 分割开
    val list1 = List("hello word", "hello tj", "scala word")
    // 扁平化处理
    val flatMap = list1.flatMap((x: String) => x.split(" "))
    flatMap.foreach(println)

    // 把新的数据集输出为键值对的形式
    val list2 = flatMap.map((_,1))
      list2.foreach(println)
    // 内存扩大了N倍，每一步计算内存都留有对象数据
    // 有没有什么现成的技术解决数据计算中间状态占用内存这一问题？Iterator，可以解决

    println("--------------艺术 再 升华----------------")
    // 迭代器中不存数据，
    val iterList = list1.iterator

    val iterFlatMap = iterList.flatMap((x: String) => x.split(" "))
//    iterFlatMap.foreach(println)
    // iterFlatMap迭代器已经把指针指向末尾，所以不会打印map
    val iterMap = iterFlatMap.map((_,1))
    while (iterMap.hasNext){
      println(iterMap.next())
    }

  }
}
