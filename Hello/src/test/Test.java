package test;

/**
 * @author josonlee
 * 参考:https://www.jianshu.com/p/aa0b01b4b844
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abc";
		String str2 = "def";
		String str3 = "abc" + "def";
		//字符串常量是编译期确定的，存在于方法区的常量池（其中也有类、方法等中定义的常量）
		System.out.println(str3=="abcdef");
		//通过+连接包含引用的字符串实际也是在堆中新建了对象，如下是新建了str1对象，以及str1+"def"对象（）
		String str4 = str1+"def";
		System.out.println(str3==str4);
		//String的intern()方法就是扩充常量池,调用intern()方法时，Java查找常量池中是否有相同Unicode的字符串常量，如果有，则返回其的引用，
		//如果没有，则在常量池中增加一个Unicode等于str的字符串并返回它的引用
		System.out.println(str3==str4.intern());
		System.out.println(str3==str4);//str4还是那个str4，并没有指向intern返回的对象
		str4=str4.intern();
		System.out.println(str3==str4);
		//通过new创建的Str不能在编译期确定，不是常量不能在常量池中，而是在堆中（是一个类对象）
		String str5 = new String("abcdef");//"abcdef"是在常量池中，但new出的对象会复制一份"abcdef"放在在堆中
		System.out.println(str3==str5);
		String str6 = new String("abcdef");//也是一个对象，不等于str5
		System.out.println(str5==str6);
		/**
		 * new创建字符串时首先查看池中是否有相同值的字符串，
		 * 如果有，则拷贝一份到堆中，然后返回堆中的地址；
		 * 如果池中没有，则在堆中创建一份，然后返回堆中的地址
		 * （注意，此时不需要从堆中复制到池中，否则导致浪费池的空间）
		 */
	}

}
