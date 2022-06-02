# ScalaEdu
Scala语言学习

## 1、解释Scala是什么语言

语言分类：解释型、编译型

编译型：C

解释型：Python



java是啥？

​	1、需要编译    字节码

​	2、解释执行、直接执行

C：可移植性、对应不同平台，各自编译

JAVA：可移动性，一次编译，到处运行       JVM是核心

编译型、解释型区别：

是否是强类型，什么是类型？类型就是宽度，在编译时，需要指定类型，开辟一定空间，把数据存储进去，防止溢出



Scala：可以在JVM 和 JavaScript运行



语言模型：面向过程，面向对象，函数式

Scala  是一个 面向对象和函数式编程语言



**Scala  可以运行在 JVM上**



Scala         java

解释器       解释器

​          JVM



## 2、基础语法

spark  ：2.3.x      - ->   Scala：2.11    - ->   JDK：1.8.uxx

### 1、Scala数据类型

![image-20211208165807181](C:\Users\it_mr\AppData\Roaming\Typora\typora-user-images\image-20211208165807181.png)

| 数据类型 | 描述                                                         |
| :------- | :----------------------------------------------------------- |
| Byte     | 8位有符号补码整数。数值区间为 -128 到 127                    |
| Short    | 16位有符号补码整数。数值区间为 -32768 到 32767               |
| Int      | 32位有符号补码整数。数值区间为 -2147483648 到 2147483647     |
| Long     | 64位有符号补码整数。数值区间为 -9223372036854775808 到 9223372036854775807 |
| Float    | 32 位, IEEE 754 标准的单精度浮点数                           |
| Double   | 64 位 IEEE 754 标准的双精度浮点数                            |
| Char     | 16位无符号Unicode字符, 区间值为 U+0000 到 U+FFFF             |
| String   | 字符序列                                                     |
| Boolean  | true或false                                                  |
| Unit     | 表示无值，和其他语言中void等同。用作不返回任何结果的方法的结果类型。Unit只有一个实例值，写成()。 |
| Null     | null 或空引用                                                |
| Nothing  | Nothing类型在Scala的类层级的最底端；它是任何其他类型的子类型。 |
| Any      | Any是所有其他类的超类                                        |
| AnyRef   | AnyRef类是Scala里所有引用类(reference class)的基类           |

[`Any`](https://www.scala-lang.org/api/2.12.1/scala/Any.html)是所有类型的超类型，也称为顶级类 型。它定义了一些通用的方法如`equals`、`hashCode`和`toString`。`Any`有两个直接子类：`AnyVal`和`AnyRef`。

`AnyVal`代表值类型。有9个预定义的非空的值类型分别是：`Double`、`Float`、`Long`、`Int`、`Short`、`Byte`、`Char`、`Unit`和`Boolean`。`Unit`是不带任何意义的值类型，它仅有一个实例可以像这样声明：`()`。所有的函数必须有返回，所以说有时候`Unit`也是有用的返回类型。

`AnyRef`代表引用类型。所有非值类型都被定义为引用类型。在Scala中，每个用户自定义的类型都是`AnyRef`的子类型。如果Scala被应用在Java的运行环境中，`AnyRef`相当于`java.lang.Object`。

### 2、main

main 方法只能写在 Object定义的文件中

### 3、Object

object：静态、单例  不用new 就可以直接使用

### 4、Class

class：必须new才能使用， 在class 中裸露的代码是默认构造中的，代表有默认构造

### 5、伴生关系

Class 和 Object 名称相同

### 6、方法

```scala
object Lession02 { 
  def main(args: Array[String]): Unit = {
    // 成员方法，赋值给一个引用，会直接调用。如果不想执行  方法名 + 空格 + 下划线
    var oo = ooxx(1)	// 输出 hello word ooxx 1
    var xx = ooxx _	// 不执行
    var ff = dd	// 输出 hello word dd  无参方法 () 可以省略
    var gg = dd _	// 不执行
  }
  // 成员方法
  def ooxx(a:Int): Unit ={
    println(s"hello word ooxx $a")
  }
  def dd(): Unit ={
    println("hello word dd")
  }
}
```

Scala 是包级别区分，类名可以和文件名不一致

类体或 object 体中 裸露的代码，会优先执行，main 方法后执行

```scala
// 类里 裸露的代码是默认构造中的  有默认构造
// 类名构造器里面的参数就是成员属性，默认是 val , private
// 只有类名构造其中的参数可以设置为 var ，其他方法中的参数都是 val 类型，且不允许设置为 var 类型
class test1(sex:String){
  var name = "lisi"

//  def this(xname:String){
//    // 定义的个性构造必须调用默认构造
//    this()
//    name=xname
//  }

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
```

var 变量    val 常量

Scala 中可以多继承

## 3、流程控制

### 1、if

和 Java 没有区别

```scala
var a = 1
if (a < 0) {
  println(s"$a < 0")
} else {
  println(s"$a >= 0")
}
```

### 2、while

```scala
var aa = 0
while (aa < 5) {
  println(s"$aa < 0")
  // scala 中没有 a++ ，可以使用a+=1 代替
  aa+=1
}
```

### 3、for

在 Scala 中 没有普通的 for 循环，只有迭代的 for 循环

```scala
// to 包含 设置的结尾值
var seq = 1 to 10
println(seq)

// until 不包含设置的结尾值
var seq1 = 1 until(10)
println(seq1)

// Scala 中的增强 for 循环，相比较 Java 中的增强 for 循环 for(String s : List) 区别就是 符号的变化 “for (i <- seq1)”
// 在 Scala 中 没有像 Java 中，break，continue 关键字用于退出循环，但是可以在后面跟上 "for (i <- seq1 if (i%2==0))" 输出偶数
for (i <- seq1 if (i%2==0)) {
    println(i)
}
```

九九乘法表：

```Scala
// 这种进入循环 81 次
for (i <- 1 to 9;j <- 1 to 9) {
    if (j <= i) print(s"$i * $j = ${i*j}\t")
    if (j == i) println()
  }
}
// 这种进入循环 45 次
for (i <- 1 to 9;j <- 1 to 9 if j <= i) {
    print(s"$i * $j = ${i*j}\t")
    if (j == i) println()
  }
}
```

#### yield使用：

```Scala
// yield 用于回收循环中的值，存放入集合中
val ints = for (i <- 1 to 10) yield i
println(ints)


// yield 后面可以跟 {}，用于其他业务处理
val ints = for (i <- 1 to 10) yield {
    var a = 2
    i + a
}
for (i <- ints){
    println(i)
}
```

## 4、函数

### 1、基础函数

#### 1、返回值

1、没有返回值

```Scala
def fun01(){
  println("hello word")
}
 var x = fun01()
println(x)	// 输出的值为：()
```

2、有返回值，需在方法后加上 "="，表示有返回值

```Scala
def fun02()={
  3
}
var y = fun02()
println(y)	// 输出的值为：3
```

3、指定类型返回值，指定类型和返回类型不一致会报错

```Scala
def fun02():Int={
  3
}
var y = fun02()
println(y)
```

#### 2、参数

```scala
// 有参数的必须指定参数类型，不然报错，参数只能是 val，不能为 var，在方法内不能被修改
def fun03(a:Int){
  println(a)
}
fun03(3)
```

### 2、递归函数

```scala
// 递归先写触底，不然会报 栈溢出
def fun04(num : Int): Int={
    if (num == 1){
        num
    } else {
        num * fun04(num -1)
    }
}
println(fun04(4))
```

### 3、默认值函数

```scala
// 调用时可以不用传参数，直接使用默认值
def fun05(a:Int=5,b:String="abc"){
  println(s"$a\t$b")
}
fun05()
fun05(6,"bcd")	// 输出 6 bcd
fun05(6)	// 输出 6 abc
// 使用第一个为默认值，传第二个为定义值
fun05(b="def")	// 输出 5 def
```

### 4、匿名函数

```scala
// 匿名函数调用时，需要把这个函数赋给一个变量，直接调用这个变量后面带参数（w(1,2)），进行使用
var y = (a:Int,b:Int) => {
  a+b
}
var yy:Int = y(1,2)
println(yy)

// 匿名函数，类型表示方式
var w:(Int,Int)=>Int =(a:Int,b:Int) => {
  a+b
}
var ww:Int = w(1,2)
println(ww)
```

**函数是第一类值**

**1、签名：(Int, Int) => Int      （参数类型列表）=>  返回值类型**

**2、匿名函数：(a:Int, b:Int)  => { a+b }       （参数实现列表）=>  函数体**

### 5、嵌套函数

```scala
// 在 fun06 的作用域中，调用 fun05，自己域内的 fun05 优先级最高
def fun03(a:Int){
    println(a)
}

def fun05(){
  println("fun05")
}

def fun06(a:String): Unit ={
  def fun05(){
    println(a)
  }
  fun05()
  fun03(1)
}
fun06("hello")	// 输出 hello  1
```

### 6、偏应用函数

```scala
def fun07(dt:Date,tp:String,msg:String): Unit ={
  println(s"$dt\t$tp\t$msg")
}
fun07(new Date(),"info","ok")

// 实现一个 info 的方法，赋值给变量
var info = fun07(_:Date,"info",_:String)
// 调用 info 时，就只用传递 时间 和 消息 两个参数
info(new Date(),"ok")
```

### 7、可变参数函数

**可变参数，类型需要一致**，定义第一个参数后，后面加一个 * 就表示可变参数

a就代表数据集，可以使用 for 循环取出所有数据

```scala
def fun08(a:Int*): Unit ={
  for (e <- a) {
    println(e)
  }
}
fun08(3)	// 输出 3
fun08(1,2,3)	// 输出 1,2,3

# 第二种写法
def fun08(a:Int*): Unit ={
 //def foreach[U](f: A => U): Unit         foreach 函数定义
  a.foreach((x:Int) => {println(x)})
}
# 第三种写法，如果匿名函数参数值在函数体中只会出现一次
def fun08(a:Int*): Unit ={
  a.foreach(println(_))
}
# 第四种写法，直接调用println函数
def fun08(a:Int*): Unit ={
  a.foreach(println)
}
```

### 8、高阶函数

**函数作为一个参数**

```scala
// 实现一个计算器，传入两个参数，一个函数，得出结果
def computer(a:Int, b:Int, f:(Int,Int)=>Int): Unit ={
  val req = f(a, b)
  println(req)
}
computer(3,8,(x:Int,y:Int)=>{x+y})
computer(3,8,(x:Int,y:Int)=>{x*y})
// 参数列表中的参数依次出现在函数体中一次，可写为如下形式
computer(3,8,_*_)	// 输出24
```

**函数作为返回值**

```scala
def computer(a:Int, b:Int, f:(Int,Int)=>Int): Unit ={
  val req = f(a, b)
  println(req)
}

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
```

### 9、柯里化

```scala
// 柯里化(Currying)指的是将原来接受两个参数的函数变成新的接受一个参数的函数的过程。新的函数返回一个以原有二个参数为参数的函数
// 可以适用于传递多个不同类型的参数，避免函数体内进行类型转换
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
```

## 5、集合容器

**Scala 中有两个包：immutable(不可变)、mutable(可变)，默认是不可变的**

### 1、可以使用Java的Collections

```scala
val linkedList = new util.LinkedList[String]()
linkedList.add("String")
```

### 2、Scala自己的Collections

#### 1、数组（Array）

```scala
// Java 中泛型是 <> ，在Scala中泛型使用的是 [ ]
// scala 数组获取指定下标数据 使用 ()
// val 约等于 final ，不可变描述的时 val 指定的引用的值（值：字面值、地址）
val array = Array[Int](1, 2, 3, 4)	// 使用数组时最好定义下泛型
println(array(1))	// 输出 2
array(1)=99	// 指定下标赋值
println(array(1))	// 输出 99
array.foreach(println)
```

#### 2、链表（List）

**链表顺序：输入顺序，可以重复**

```scala
// 不可变List
val list01 = List(1, 2, 3, 4, 5, 4, 3, 2)
list01.foreach(println)

// 可变ListBuffer
val listBuffer = new ListBuffer[Int]()
listBuffer.+=(34,32)	// 添加元素到链表中
listBuffer.+=:(35)	// 从链表头添加元素
listBuffer.-=(35)	// 从链表中删除指定元素
listBuffer.foreach(println)
```

#### 3、Set

**Set 无序性，去重**

```Scala
// 不可变Set
val set01 = Set(2, 3, 2, 1)
set01.foreach(println)	// 输出 2 3 1

// 可变Set
/**
 * import 引包可以在代码中，不必像 Java 必须定义在类上
 * 引入后后面的 Set 就都是可变的，如果还想使用不可变的,需要指定包路径 scala.collection.immutable.Set
 */
import scala.collection.mutable.Set
val set02 = mutable.Set(11, 22, 44, 22, 33)
set02.add(88)
set02.foreach(println)

val set03 = scala.collection.immutable.Set(99, 88, 77)	// 没有 add()
set03.foreach(println)
```

#### 4、Tuple

可以放不同类型的元素，总共定义了22个 Tuple

**在 Scala 中使用 Tuple2  描述键值对**

**Tuple 中没有 foreach 方法，需要使用迭代器取出元素**

```scala
// Tuple2 表示可以存2个元素
val t2 = Tuple2(1, "sfsf")
val t4 = Tuple4((a:Int,b:Int)=>{a+b}, 3, (a:Int)=>{a+8}, 4)
// 取单个元素
println(t2._2)	// 输出 sfsf
println(t4._3)  // 输出 <function1> function表示函数，1表示一个参数
println(t4._1(2, 3))  // 输出函数结果 5

// 使用迭代器输出所有元素
val ite = t2.productIterator
while (ite.hasNext) {
	println(ite.next())
}
// 输出 1  sfsf
```

#### 5、Map

**存储的是 K，V 键值对形式，其中 K 不允许重复， 表示形式：（"a",33） 、 "b"->22 都可以表示键值对存储在Map中**

```scala
// 不可变 Map
val map01 = Map(("a", 33), "b" -> 22, ("a", 44))
map01.foreach(println)  // 输出 (a,44) (b,22)
println(map01.keys)  // 输出 Set(a, b)
val keysMap = map01.keys
for (elem <- keysMap) {
   println(s"key: $elem  value: ${map01(elem)}")
}
/**
 * get()，返回的是Option对象，如需取出值，需要再次调用 get/getOrElse()
 * get，针对于Map中存在的 K，直接返回 V; 针对于Map中不存在的K会报错 java.util.NoSuchElementException: key not found: 
 * getOrElse() 会自己进行空判断，针对于 Map 中存在的K，直接返回 V; 针对于 Map 中不存在的元素会直接返回 传入的参数值
 * Option: None  Some
 * None: 表示无值
 * Some: 表示有值
 */
println(map01.get("a"))  // 输出 Some(44)
println(map01.get("c"))  // 输出 None
println(map01.get("a").getOrElse())  // 输出 44
println(map01.get("c").get)	// 报错 java.util.NoSuchElementException: key not found: c
println(map01.get("c").getOrElse())  // 输出 ()
println(map01.get("c").getOrElse("hello word"))  // 输出 hello word

// 可变 Map
val map02 = scala.collection.mutable.Map(("a", 1), ("b", 2))
map02.put("c",3)
```

### 3、不可变集合容器优缺点

#### 1、优点

**中间的计算不影响原有的数据**

```scala
// 中间的计算不影响原有的数据
val list = List(1, 2, 3, 4)
val listMap = list.map((a: Int) => {
    a + 10
})
listMap.foreach(println)  // 11 12 13 14
list.foreach(println) // 1 2 3 4
```

**扁平化处理**

```scala
// 需求：把字符串根据 空格 分割开
val list1 = List("hello word", "hello tj", "scala word")
val flatMap = list1.flatMap((x: String) => x.split(" "))
flatMap.foreach(println)	// 输出 hello word hello tj scala word
```

#### 2、缺点

内存扩大了N倍，每一步计算内存都留有对象数据

有没有什么现成的技术解决数据计算中间状态占用内存这一问题？Iterator，可以解决

```scala
// 迭代器中不存数据，
val list2 = List("hello word", "hello tj", "scala word")
val iterList = list2.iterator

val iterFlatMap = iterList.flatMap((x: String) => x.split(" "))
iterFlatMap.foreach(println)
// iterFlatMap 迭代器已经把指针指向末尾，所以不会打印map
val iterMap = iterFlatMap.map((_,1))
iterMap.foreach(println)
```

#### 3、Scala-Iterator 原理

![image-20211210200023590](C:\Users\it_mr\AppData\Roaming\Typora\typora-user-images\image-20211210200023590.png)

## 6、Trait

Class 修饰的类，可以 extends 多个被 Trait 修饰的类，实现多继承，被继承类之间使用 “with” 连接

如果被 Trait 修饰的类，里面有没有实现的方法，继承类需要实现具体的方法

```scala
package com.li.bigdata.scalacode

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
  // 实现 God 类中的方法
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
    p.cry()
  }
}
```

## 7、样例类（case class）

**样例类首先是一个类，只是是一种特殊类**，它可以用来快速定义一个用于**保存数据**的类（类似于Java POJO类）

case 类在模式匹配和 actor 中经常使用到，当一个类被定义成为 case类后，Scala 会自动帮你创建一个伴生对象并帮你实现了一系列方法

```scala
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
```

## 8、Match

```scala
/**
 * match 相当于 Java中的 switch
 */
object Lenssion06_match {
  def main(args: Array[String]): Unit = {
    // 遍历每一个类型，并打印一句话
    // match 匹配时，每一个类型都需要有 case 对应，不然会报某个类型匹配不上错误
    val tup: (Double, String, Int, Boolean, Char) = (1.0, "abc", 2, false, 'a')
    val ite: Iterator[Any] = tup.productIterator
    ite.foreach {x=>{x match {
      case a: Char => println(s"$a is Char")
      case "abc" => println("is abc")
      case b: Int => if (b>1) {println(s"$b is > 1")}
      case c: Char => println(s"$c is Char")
      case d: Boolean => println(s"$d is Boolean")
      case _:Any => println("is not type")
    }}
    }
  }
}
```

## 9、PartialFunction

```scala
/**
 * 偏函数
 */
object Lession07_PartialFunction {
  def main(args: Array[String]): Unit = {
	// 入参为 Any 任意类型，返回类型为 String
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
```

## 10、Implicit

隐式转换方法

```scala
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

    // 定义一个 foreach 函数，传入需要遍历的集合 以及 对应要执行的函数
    // 人为定义方法
    def foreach[T](linkedList: util.LinkedList[T], f:T => Unit): Unit ={
      val it = linkedList.iterator()
      while (it.hasNext) f(it.next())
    }
    foreach(linked,println)

    // 定义一个类 简化上述代码
    val value = new xxx[Int](linked)
    value.foreach(println)

    // 使用 implicit 可以简化上述代码, 隐式转换方法 方法名可以任意
    implicit def dsf[T](list1:util.LinkedList[T]): xxx[T] ={
      new xxx[T](list1)
    }
    // listed 对象中没有 foreach 方法，Java 语法中会报错，这些代码会交给 Scala 编译器
    /**
     * 1.Scala 发现 listed 没有 foreach()
     * 2.去寻找有没有 implicit 定义的方法，且方法的参数正好是 List 的类型
     * 3.编译器会帮你把代码修改
     */
    linked.foreach(println)
  }
}

class xxx[T](ts: util.LinkedList[T]){
  def foreach(f:T => Unit): Unit ={
    val it = ts.iterator()
    while (it.hasNext) f(it.next())
  }
}
```

隐式转换类

```scala
def main(args: Array[String]): Unit = {
  val linked = new util.LinkedList[Int]()
  linked.add(1)
  linked.add(2)
  linked.add(3)

  // 隐式转换类
  implicit class kkk[T](ts: util.LinkedList[T]) {
     def foreach(f:T => Unit): Unit ={
       val it = ts.iterator()
       while (it.hasNext) f(it.next())
     }
  }
  // listed 对象中没有 foreach 方法，Java 语法中会报错，这些代码会交给 Scala 编译器
  /**
   * 1.Scala 发现 listed 没有foreach()
   * 2.去寻找有没有 implicit 定义的方法，且方法的参数正好是 List 的类型
   * 3.编译器会帮你把代码修改
   */
  linked.foreach(println)
}
```

隐式转换参数

```scala
def main(args: Array[String]): Unit = {
 // 隐式转换参数
 /**
  * 1、def sss(implicit name:String, age:Int) 所有参数都需 隐式转换
  *  调用时 sss("zhangsan", 1) 或者 sss 但上面需要定义全部参数 implicit val xx
  * 2、def sss(name:String)(implicit age:Int) 柯里化定义时，implicit修饰参数必须放在后面
  *  调用时 sss("zhangsan") 或者 sss("zhangsan")上面定义implicit val xx 或者 sss("zhangsan",1) 或者 sss 上面定义implicit val xx
  */
 implicit val sf:String = "lisi"
 def sss(implicit name:String): Unit ={
   println(name)
 }
 sss("zhangsan")	// 输出 zhangsan
 sss	// 输出 lisi
}

隐式转换参数 相对于 默认值参数
区别：隐式转换参数可以动态修改参数值，，更加的灵活
// 默认值参数
def cs(name:String = "zhangsan"){
    
}
```

## 11、使用 Scala 写 Spark 程序

```scala
package com.li.bigdata.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
 * 使用Scala、Java 写 Spark的WordCount程序
 * 普通项目 转成 Maven项目：项目右键Add Frameworks Support 选择Maven，修改POM 引入Spark2.3.4
 */
object ScalaToSpark {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("wordcount")
    conf.setMaster("local") // 本地运行

    // 单词统计
    val sc = new SparkContext(conf)
    val fileSpark = sc.textFile("data/testdata.text") // 读取数据文件
    // 精简代码
//    fileSpark.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).foreach(println)
    // 获取每一行数据，根据 空格 拆分
    val words = fileSpark.flatMap((s:String) => {
      s.split(" ")
    })
    // 转换为 key value 形式
    val pairWord = words.map((x: String) => {
      new Tuple2(x, 1)
    })
    // 把相同key的 value加起来
    val res = pairWord.reduceByKey((x: Int, y: Int) => {
      x + y
    })
    res.foreach(println)
  }
}
```
