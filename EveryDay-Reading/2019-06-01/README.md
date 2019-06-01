# README
今天处理了一批数据，列几个Tips吧：
- 数据处理流程
- 时间解析，SimpleDateFormat是线程不安全的，生产上容易造成时间解析错误，可以用FastDateFormat类代替
> 阿里开发者手册上强制，SimpleDateFormat 一般不定义为 static变量，如果定义为 static 变量就一定要加锁，或者使用DateUtils工具类。（也可以将SimpleDateFormat作为局部变量使用，避免多线程访问到）
> 
```java
private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
@Override
protected DateFormat initialValue() {
return new SimpleDateFormat("yyyy-MM-dd");
}
};
 
 //日期转字符串
 public static String format(Date date) {
        return threadLocal.get().format(date);
 }
 
 //字符串转日期
public static String parse(String str){
    return threadLocal.get.parse(str);
}
```

jdk 1.8中引入了一个线程安全的时间格式化类DateTimeFormatter
```java
public static void main(String[] args) {
        //DateTimeFormatter 线程安全的日期格式化类
        //日期转换为字符串 ---通过模式字符串来创建DateTimeFormatter格式器,一般用这个
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String format1 = now.format(format);
        System.out.println(format1);
        //直接使用常量创建DateTimeFormatter格式器 ISO_DATE  2018-11-12  / ISO_LOCAL_TIME 14:03:24.266  / ISO_LOCAL_DATE_TIME 2018-11-12T14:03:54.363  / BASIC_ISO_DATE  20181112 等等
        DateTimeFormatter isoDate = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDateTime now2 = LocalDateTime.now();
        String format2 = now.format(isoDate);
        System.out.println(format2);
        //字符串转换为日期
        LocalDateTime now3 = LocalDateTime.now();
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //HH24小时制，hh12小时制
        String str = "2014-04-12 01:06:09";
       // LocalDate  不包含时分秒，只有年月日
        LocalDate parse = LocalDate.parse(str, format3);
        System.out.println(parse+" parse");
        //LocalDateTime 年月日时分秒都有，不过要注意，使用localdatetime的时候，格式的时间只能是24小时制，不能用hh，不然会报错
        LocalDateTime parse1 = LocalDateTime.parse(str, format3);
        System.out.println(parse1+" parse1");
        //如果一个字符串没有时分秒，那么是不能直接转换成LocalDateTime的
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate ld = LocalDate.parse("20180306", dtf);
        //需要指定时分秒，localTime 指定时分秒部分和localDate可以组合使用
        LocalDateTime ldt = LocalDateTime.of(ld, LocalTime.of(12,12,12));
        System.out.println(ldt+" ldt");
        //instant格式化为字符串
  I     Instant now = Instant.now();
        String format = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss").format(now);
}
```

- ip地址对应地理位置解析，github上有个`ipdatabase`项目
  - git clone到本地，maven项目
  - 编译生成jar包导入maven仓库即可
    ```
    # 进入项目文件下，编译
    mvn clean package -DskipTests
    # 导入jar包到本地maven仓库
    #file是上面生成的jar包的完整地址
    #groupId、artifactId、version可以区别一个maven项目，在ipdatabase项目的pom.xml中有写
    mvn install:install-file -Dfile=/home/josonlee/xxxx/xxx/ipdatabase-1.0-SNAPSHOT.jar -DgroupId=com.ggstar -DartifactId=ipdatabase -Dversion=1.0 -Dpackaging=jar
    ```
  - 然后项目中的`pom.xml`中添加相应dependency即可，**该工具还要借助两个office相关的依赖，pom.xml中有写**
    ```
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml</artifactId>
        <version>3.14</version>
    </dependency>
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi</artifactId>
        <version>3.14</version>
    </dependency>
    ```
  - 还有`ipdatabase`中要用到自己的resource目录下的`ipDatabase.csv`和`ipRegion.xlsx`两文件，记得拷到自己项目的resource目录下

- jdbc操作
  - [Java JDBC操作、连接池与查询模板](http://patchouli-know.com/2016/11/25/java-db-connection-pool/)
  - [java之JDBC](https://juejin.im/post/5c75e6666fb9a049cd54dc88)