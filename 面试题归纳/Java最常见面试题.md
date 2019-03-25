## **一、Java 基础**

1.JDK 和 JRE 有什么区别？

2.== 和 equals 的区别是什么？

3.两个对象的 hashCode()相同，则 equals()也一定为 true，对吗？

> Java核心卷中提过重写equals方法的话就必须重写hashCode方法，这样equals返回true的话，则两个对象的hashCode一定相等；反之不一定（因为hashCode方法是自己重写自定义的，也可能会发生哈希冲突等）
>
> **但有些不重写hashCode方法（这种是设计有问题**，则会使用Object的hashCode方法导致equals返回true，哈希值却不相等。
>
> [这里有篇讲解具体的hashCode和equals若干问题的文章](https://www.cnblogs.com/skywang12345/p/3324958.html) 

4.final 在 java 中有什么作用？

5.java 中的 Math.round(-1.5) 等于多少？

> -1，Math.round(x)  = Math.floor(x+0.5)

6.String 属于基础的数据类型吗？

7.java 中操作字符串都有哪些类？它们之间有什么区别？

> String、StringBuffer、StringBuilder，可变与否、线程安全与否、效率三个角度

8.String str="i"与 String str=new String("i")一样吗？

> 不一样。理解常量池、堆、栈、方法区

9.如何将字符串反转？

> new StringBuffer(str).reverse().toString()

10.String 类的常用方法都有那些？

11.抽象类必须要有抽象方法吗？

> 否

12.普通类和抽象类有哪些区别？

13.抽象类能使用 final 修饰吗？

> 否，final修饰的类不允许被继承

14.接口和抽象类有什么区别？

> 接口是行为抽象，抽象类是类的抽象
>
> 类可以实现多接口，但只能继承一个抽象类
>
> 类实现接口要实现接口中所有非默认（default）、静态方法，抽象类则不一定
>
> > default方法不允许override重写Object类的默认方法，如equals、hashCode等。一旦所有接口的实例都是**Object的子类**，所有接口实例**都已经有对equals/hashCode/toString等方法非默认 实现**。因此，一个在接口上的这些默认方法都是没用的，它也**不会被编译**。
>
> 接口中方法默认public、变量默认final，java8后方法可以有默认实现（default关键字），也可以有static方法（必须有方法体），其他方法由实现该接口的类去定义方法体。抽象类中的抽象方法不允许有方法体，可以有非抽象方法（必须有方法体）
>
> > 接口的静态方法可以由接口名直接调用，抽象类中同样也可以有静态方法，一样由抽象类名调用
>
> 接口中只能定义**初始化了的**final实例域（final默认，可省略），抽象类随便

15.java 中 IO 流分为几种？

16.BIO、NIO、AIO 有什么区别？

17.Files的常用方法都有哪些？

## **二、容器**

Java容器可分为两大类：参考：[Java集合总结](https://segmentfault.com/a/1190000014403696#articleHeader14)

- Collection
  - List
    - **ArrayList**
    - LinkedList
    - Vector(了解，已过时)
  - Set
    - **HashSet**
      - LinkedHashSet
    - TreeSet
- Map
  - **HashMap**
    - LinkedHashMap
  - TreeMap
  - ConcurrentHashMap
  - Hashtable(了解，，已过时)

18.java 容器都有哪些？

19.Collection 和 Collections 有什么区别？

20.List、Set、Map 之间的区别是什么？

21.HashMap 和 Hashtable 有什么区别？

22.如何决定使用 HashMap 还是 TreeMap？

23.说一下 HashMap 的实现原理？

24.说一下 HashSet 的实现原理？

25.ArrayList 和 LinkedList 的区别是什么？

26.如何实现数组和 List 之间的转换？

27.ArrayList 和 Vector 的区别是什么？

28.Array 和 ArrayList 有何区别？

29.在 Queue 中 poll()和 remove()有什么区别？

30.哪些集合类是线程安全的？

31.迭代器 Iterator 是什么？

32.Iterator 怎么使用？有什么特点？

33.Iterator 和 ListIterator 有什么区别？

34.怎么确保一个集合不能被修改？

## **三、多线程**

35.并行和并发有什么区别？

36.线程和进程的区别？

37.守护线程是什么？

38.创建线程有哪几种方式？

> 1. 继承Thread类，实现run()方法
> 2. 实现Runnable接口的run()方法
> 3. 实现callable接口的call()方法，多和Future、FutureTask配合使用
> 4. 构造线程池

39.说一下 runnable 和 callable 有什么区别？

> 相同：这两都可用来创建线程，都是接口，都用Thread.start()来启动线程
>
> 相异：Runnable无返回值，Callable有返回值（可调用FutureTask.get()得到）。其次Callable中的call()方法会抛出异常，Runnable的run()方法异常只能在内部消化，不能往上继续抛
>
> ```java
> //CallableDemo是实现callable接口的类
> CallableDemo call = new CallableDemo();
> FutureTask<Integer> ft = new FutureTask<Integer>(call);
> new Thread(ft).start();
> ```

40.线程有哪些状态？

41.sleep() 和 wait() 有什么区别？

42.notify()和 notifyAll()有什么区别？

43.线程的 run()和 start()有什么区别？

44.创建线程池有哪几种方式？

45.线程池都有哪些状态？

46.线程池中 submit()和 execute()方法有什么区别？

47.在 java 程序中怎么保证多线程的运行安全？

48.多线程锁的升级原理是什么？

49.什么是死锁？

50.怎么防止死锁？

51.ThreadLocal 是什么？有哪些使用场景？

52.说一下 synchronized 底层实现原理？

53.synchronized 和 volatile 的区别是什么？

54.synchronized 和 Lock 有什么区别？

55.synchronized 和 ReentrantLock 区别是什么？

56.说一下 atomic 的原理？

## **四、反射**

57.什么是反射？

58.什么是 java 序列化？什么情况下需要序列化？

59.动态代理是什么？有哪些应用？

60.怎么实现动态代理？

## **五、对象拷贝**

61.为什么要使用克隆？

62.如何实现对象克隆？

63.深拷贝和浅拷贝区别是什么？

**六、省略**

## **七、异常**

74.throw 和 throws 的区别？

75.final、finally、finalize 有什么区别？

76.try-catch-finally 中哪个部分可以省略？

77.try-catch-finally 中，如果 catch 中 return 了，finally 还会执行吗？

78.常见的异常类有哪些？

## **八、网络**

79.http 响应码 301 和 302 代表的是什么？有什么区别？

80.forward 和 redirect 的区别？

81.简述 tcp 和 udp的区别？

82.tcp 为什么要三次握手，两次不行吗？为什么？

83.说一下 tcp 粘包是怎么产生的？

84.OSI 的七层模型都有哪些？

85.get 和 post 请求有哪些区别？

86.如何实现跨域？

87.说一下 JSONP 实现原理？

## **九、设计模式**

88.说一下你熟悉的设计模式？

89.简单工厂和抽象工厂有什么区别？

**十～十四、省略**

## **十五、Kafka**

152.kafka 可以脱离 zookeeper 单独使用吗？为什么？

153.kafka 有几种数据保留的策略？

154.kafka 同时设置了 7 天和 10G 清除数据，到第五天的时候消息达到了 10G，这个时候 kafka 将如何处理？

155.什么情况会导致 kafka 运行变慢？

156.使用 kafka 集群需要注意什么？

## **十六、Zookeeper**

157.zookeeper 是什么？

158.zookeeper 都有哪些功能？

159.zookeeper 有几种部署模式？

160.zookeeper 怎么保证主从节点的状态同步？

161.集群中为什么要有主节点？

162.集群中有 3 台服务器，其中一个节点宕机，这个时候 zookeeper 还可以使用吗？

163.说一下 zookeeper 的通知机制？

## **十七、MySql**

164.数据库的三范式是什么？

165.一张自增表里面总共有 7 条数据，删除了最后 2 条数据，重启 mysql 数据库，又插入了一条数据，此时 id 是几？

166.如何获取当前数据库版本？

167.说一下 ACID 是什么？

168.char 和 varchar 的区别是什么？

169.float 和 double 的区别是什么？

170.mysql 的内连接、左连接、右连接有什么区别？

171.mysql 索引是怎么实现的？

172.怎么验证 mysql 的索引是否满足需求？

173.说一下数据库的事务隔离？

174.说一下 mysql 常用的引擎？

175.说一下 mysql 的行锁和表锁？

176.说一下乐观锁和悲观锁？

177.mysql 问题排查都有哪些手段？

178.如何做 mysql 的性能优化？

## **十八、Redis**

179.redis 是什么？都有哪些使用场景？

180.redis 有哪些功能？

181.redis 和 memecache 有什么区别？

182.redis 为什么是单线程的？

183.什么是缓存穿透？怎么解决？

184.redis 支持的数据类型有哪些？

185.redis 支持的 java 客户端都有哪些？

186.jedis 和 redisson 有哪些区别？

187.怎么保证缓存和数据库数据的一致性？

188.redis 持久化有几种方式？

189.redis 怎么实现分布式锁？

190.redis 分布式锁有什么缺陷？

191.redis 如何做内存优化？

192.redis 淘汰策略有哪些？

193.redis 常见的性能问题有哪些？该如何解决？

## **十九、JVM**

194.说一下 jvm 的主要组成部分？及其作用？

195.说一下 jvm 运行时数据区？

196.说一下堆栈的区别？

197.队列和栈是什么？有什么区别？

198.什么是双亲委派模型？

199.说一下类加载的执行过程？

200.怎么判断对象是否可以被回收？

201.java 中都有哪些引用类型？

202.说一下 jvm 有哪些垃圾回收算法？

203.说一下 jvm 有哪些垃圾回收器？

204.详细介绍一下 CMS 垃圾回收器？

205.新生代垃圾回收器和老生代垃圾回收器都有哪些？有什么区别？

206.简述分代垃圾回收器是怎么工作的？

207.说一下 jvm 调优的工具？

208.常用的 jvm 调优的参数都有哪些？

## 

省略部分涉及java web方面，本人无感

题目转至：https://www.nowcoder.com/discuss/157387 ，解答部分个人归纳



### 3-25收集

1、介绍一下Syncronized锁，如果用这个关键字修饰一个静态方法，锁住了什么？如果修饰成员方法，锁住了什么？ 

 2、介绍一下volatile？ 

 3、锁有了解嘛，说一下Synchronized和lock 

 4、讲一讲Java里面的final关键字怎么用的？

#### **5、线程**  

 	1、多线程中的i++线程安全吗？为什么？ 

 	2、如何线程安全的实现一个计数器？ 

 	3、多线程同步的方法 

 	4、介绍一下生产者消费者模式？ 

 	5、线程，进程，然后线程创建有很大开销，怎么优化？ 

 	6、线程池运行流程，参数，策略 

 	7、讲一下AQS吧。 

 	8、创建线程的方法，哪个更好，为什么？ 

 	9、Java中有几种方式启动一个线程？ 

 	10、Java中有几种线程池？ 

 	11、线程池有什么好处？ 

 	12、cyclicbarrier和countdownlatch的区别 

 	13、如何理解Java多线程回调方法？ 

 	14、创建线程有几种不同的方式？你喜欢哪一种？为什么？ 

 	15、概括的解释下线程的几种可用状态。 

 	16、同步方法和同步代码块的区别是什么？ 

 	17、启动线程有哪几种方式，线程池有哪几种？ 

 	18、在监视器(Monitor)内部，是如何做线程同步的？程序应该做哪种级别的同步？ 

 	19、sleep() 和 wait() 有什么区别？ 

 	20、同步和异步有何异同，在什么情况下分别使用他们？举例说明。 

 	21、设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。使用内部类实现线程，对j增减的时候没有考虑顺序问题。 

 	22、启动一个线程是用run()还是start()? 

 	23、请说出你所知道的线程同步的方法 

 	24、多线程有几种实现方法,都是什么?同步有几种实现方法,都是什么? 

 	25、java中有几种方法可以实现一个线程？用什么关键字修饰同步方法? stop()和suspend()方法为何不推荐使用？ 

 	26、线程的sleep()方法和yield()方法有什么区别？ 

 	27、当一个线程进入一个对象的synchronized方法A之后，其它线程是否可进入此对象的synchronized方法B？ 

 	28、请说出与线程同步以及线程调度相关的方法。 

 	29、举例说明同步和异步 

 	30、什么是线程池（thread pool）？ 

 	31、说说线程的基本状态以及状态之间的关系？ 

 	32、如何保证线程安全？ 

####  **6、锁**   

​	 1、讲一下非公平锁和公平锁在reetrantlock里的实现。 

 	2、讲一下synchronized，可重入怎么实现。 

 	3、锁和同步的区别。 

 	4、什么是死锁(deadlock)？ 

 	5、如何确保N个线程可以访问N个资源同时又不导致死锁？ 

 	6、请你简述synchronized和java.util.concurrent.locks.Lock的异同？ 

**9、JVM**  	   

 	1、JVM回收算法和回收器，CMS采用哪种回收算法，怎么解决内存碎片问题？ 

 	2、类加载过程 

 	3、JVM分区 

 	4、eden区，survial区? 

 	5、JAVA虚拟机的作用? 

 	6、GC中如何判断对象需要被回收？ 

 	7、JAVA虚拟机中，哪些可作为ROOT对象？ 

 	8、JVM内存模型是什么？ 

 	9、jvm是如何实现线程？ 

 	10、jvm最大内存限制多少 

 	11、什么是Java虚拟机？为什么Java被称作是“平台无关的编程语言”？ 

 	12、描述一下JVM加载class文件的原理机制? 

### **10、GC**   

 	1、java中内存泄露是啥，什么时候出现内存泄露？ 

 	2、minor gc如果运行的很频繁，可能是什么原因引起的，minor gc如果运行的很慢，可能是什么原因引起的? 

 	3、阐述GC算法 

 	4、GC是什么? 为什么要有GC? 

 	5、垃圾回收的优点和原理。并考虑2种回收机制 

 	6、java中会存在内存泄漏吗，请简单描述。 

 	7、垃圾回收器的基本原理是什么？垃圾回收器可以马上回收内存吗？有什么办法主动通知虚拟机进行垃圾回收？（垃圾回收） 

