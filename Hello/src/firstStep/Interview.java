package firstStep;

/**
 * @author josonlee
 */
class A {
  public A() {
	  System.out.println("this is A");
  }
}

/**
 * @author josonlee
 */
class B {
  public B(){
	  System.out.println("this is B");
  }
}
interface C{
	default void cFun() {System.out.println("default func| interface");}
	static  void ccFun() {System.out.println("static func| interface");}
	void dFunc();
}
public class Interview extends A implements C{
	private static String nameString = "lzw";
	public static String nameTest = "lzw";
	private static int age = 20;
	private double toDay;
	public final static String DATE = "2020";
	
	public Interview(String name,double day) {
		// TODO Auto-generated constructor stub
		Interview.nameTest = name;
		this.toDay = day;
	}
	public static void print_static() {
		System.out.println(DATE);
	}
	public void print() {
		cFun();
		System.out.println(nameString+" "+age+" "+toDay);
		System.out.println(this.getClass().getSimpleName()+":"+DATE+" "+nameTest);
	}
	@Override
	public void dFunc() {
		// TODO Auto-generated method stub
		System.out.println("接口中非default方法必须实现");
	}
}
