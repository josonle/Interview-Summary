package test;
import firstStep.InterfaceTest;
import firstStep.Interview;

public class Utils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//The static field Interview.nameString should be accessed in a static way
		InterfaceTest.ccFun();
		System.out.println(InterfaceTest.a);
		System.out.println(Interview.nameTest);
		Interview day1 = new Interview("josonlee", 0.99);
		day1.print();
		Interview.nameTest = "hadoop";
		System.out.println(Interview.nameTest);
//		Interview.print_static();
	}

}
