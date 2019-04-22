package 编程之法.String;

/**
 * @author josonlee 字符串转整数 从左往右扫描，乘10相加；不过要考虑第一位是否为+/-，是否输入不合规范字符，是否溢出
 * 
 *         如何处理溢出？ 一、转出long 二、判断溢出则相应返回MAX_INT/MIN_INT即可
 */
public class strToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(toInt("-154769115198"));
		System.out.println(toInt("-1257778256"));
		System.out.println(toInt("24134 a1243"));
		System.out.println(toInt("1812333546"));
		System.out.println(181233354-Integer.MAX_VALUE/10>0);
	}

	public static int toInt(String str) {
		if (str == null)
			return 0;
		int flag = 0;
		switch (str.charAt(0)) {
		case '+':
			flag = 1;
			break;
		case '-':
			flag = -1;
			break;
		default:
			break;
		}
		int tmp = 0;
		if (flag == 0) {
			tmp = addTo(0, str);
		} else if (flag == 1) {
			tmp = addTo(1, str);
		} else {
			tmp = addTo(1, str);
			tmp = tmp==Integer.MIN_VALUE?tmp:-tmp;
		}
		return tmp;
	}
	
	public static int addTo(int start,String str) {
		int tmp = 0;
		for (int i = start; i < str.length(); i++) {
			int x = str.charAt(i) - '0';
			if (x > 9 || x < 0) {
				tmp = 0;
				break;
			}
			if (tmp > Integer.MAX_VALUE / 10) {
				tmp = Integer.MAX_VALUE;
				break;
			} else {
				tmp = 10*tmp + x;
			}
		}
		return tmp;
	}
}
