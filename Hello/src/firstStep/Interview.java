package firstStep;

public class Interview {
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
		System.out.println(nameString+" "+age+" "+toDay);
		System.out.println(this.getClass().getSimpleName()+":"+DATE+" "+nameTest);
	}
}
