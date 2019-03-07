package firstStep;

public interface InterfaceTest {
	final int a=1;
	default void cFun() {System.out.println("default func| interface");}
	static  void ccFun() {System.out.println("static func| interface");}
	void dFunc();
}
