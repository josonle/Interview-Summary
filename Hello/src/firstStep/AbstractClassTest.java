package firstStep;

public class AbstractClassTest extends abstractClass{
	public AbstractClassTest() {
		// TODO Auto-generated constructor stub
		System.out.println("子类构造器");
	}
	@Override
	void print() {
		// TODO Auto-generated method stub
		System.out.println("test");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractClassTest.aFunc();//抽象类中可以定义静态方法，可直接由类名调用
		//abstractClass.aFunc();
		new AbstractClassTest().print();
	}

}

abstract class abstractClass{
	abstract void print();
	public abstractClass() {//抽象类中可以定义构造器，虽然不能初始化，任然可被子类继承
		System.out.println("abstract class");
	}
	public static void aFunc() {
		System.out.println("i am static func");
	}
}
