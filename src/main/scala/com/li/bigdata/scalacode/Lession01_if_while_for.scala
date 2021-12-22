package com.li.bigdata.scalacode

/**
 * 流程控制
 */
object Lession01_if_while_for {

  def main(args: Array[String]): Unit = {
    /**
     * if
     * while
     * for
     */
    println("-------------if else 判断------------------")
    var a = 1
    if (a < 0) {
      println(s"$a < 0")
    } else {
      println(s"$a >= 0")
    }

    println("-------------while循环------------------")
    var aa = 0
    while (aa < 5) {
      println(s"$aa < 5")
      // scala 中没有 a++ ，使用a+=1 代替
      aa+=1
    }

    println("-------------for循环------------------")

//    for (in s=0;s<1;s+=1)
    // to 包含 设置的结尾值
    var seq = 1 to 10
    println(seq)

    // until 不包含设置的结尾值
    var seq1 = 1 until(10)
    println(seq1)

    // Scala中的增强for循环，相比较Java 中的增强for循环 for(String s : List) 区别就是 符号的变化 “for (i <- seq1)”
    // 在Scala中 没有像Java中，break，continue 关键字用于退出循环，但是可以在后面跟上 "for (i <- seq1 if (i%2==0))" 输出偶数
    for (i <- seq1 if (i%2==0)) {
      println(i)
    }
    println("===========九九乘法表================")
    for (i <- 1 to 9;j <- 1 to 9 if j <= i) {
      print(s"$i * $j = ${i*j}\t")
      if (j == i) println()
    }

    println("===========yield================")
    // yield 用于回收循环中的值，存放入集合中
    // yield 后面可以跟{}，用于其他业务处理
    val ints = for (i <- 1 to 10) yield {
      var a = 2
      i + a
    }
    for (i <- ints) {
      println(i)
    }
  }
}
