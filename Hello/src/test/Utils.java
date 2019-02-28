package test;
import firstStep.Interview;

public class Utils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//The static field Interview.nameString should be accessed in a static way
		Interview day1 = new Interview("josonlee", 0.99);
		day1.print();
		Interview.print_static();
	}

}
