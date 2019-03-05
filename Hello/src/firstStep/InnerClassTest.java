package firstStep;

public class InnerClassTest {
	private int a ;
	public int b;
	private static int c;
	private final int d = 0;
	private String str = "a";
	
	public class inner1{
		private int aInner;
		private final int bInner =0;
		public inner1() {
			// TODO Auto-generated constructor stub
		}
		public void print() {
			System.out.println(a+b+c+d+str);
		}
		/*
		 * error：内部类中不可定义静态域、方法
		 * private static int a;
		 * public static void prints() { System.out.println(a+b+c+d+str); }
		 */
	}
	public static class inner2{
		private static int c;//静态类内部可以定义静态域、方法
		public inner2() {
			// TODO Auto-generated constructor stub
		}
		/**
		public void print() {
			System.out.println(a+b+c+d+str);//error：静态类中只能访问外围类中的静态数据、方法
		}
		
		public static void prints() {//静态类内部可以定义静态域、方法
			System.out.println(a+b+c+d+str);//error：静态类中只能访问外围类中的静态数据、方法
		}
		*/
	}
	public abstract class inner3{
		public inner3() {//抽象类中可以定义构造器，虽然不能初始化
			System.out.println("abstract class");
		}
		//public abstract void print() {}//抽象方法不允许有方法体，{}也是方法体
	}
}


