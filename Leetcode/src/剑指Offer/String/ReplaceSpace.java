package 剑指Offer.String;

/**
 * @author josonlee
 * @category String
 * @title 04:请实现一个函数，把字符串中的每个空格替换成"%20"。 例如输入“We are
 *        happy.”，则输出“We%20are%20happy.”
 */
public class ReplaceSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "we are happy ";
		String string2 = " we  are ";
		String string3 = " ";
		System.out.println(string.replaceAll(" ", "%20"));
		System.out.println(solution4(string));
		System.out.println(solution4(string2));
		System.out.println(solution4(string3));
	}
	/**
	 * 时间复杂度O(n),空间复杂度O(n)
	 * @param str
	 * @return
	 */
	public static String solution4(String str) {
		if (str.equals("")) {
			return str;
		}
		int count = 0;
		char[] cList = str.toCharArray();
		for (char c : cList) {
			if (c == ' ') {
				count++;
			}
		}
		char[] newStr = new char[str.length() + count * 2];
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			if (cList[i] != ' ') {
				newStr[i+flag] = cList[i];//flag每次遇空格，后移两位加2
			} else {
				newStr[i+flag] = '%';
				newStr[i + 1+flag] = '2';
				newStr[i + 2+flag] = '0';
				flag += 2;
			}
		}
		return new String(newStr);
	}
}
