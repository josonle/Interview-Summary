package Leetcode.StringSolution;

/**
 * @author josonlee
 * @title 给定两个二进制字符串，返回他们的和（用二进制表示）。输入为非空字符串且只包含数字 1 和 0。
 * a="1011",b="1",a+b="1100"
 */
public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("110", "10"));
	}

	public static String addBinary(String a, String b) {
        StringBuffer str = new StringBuffer();
        int l1 = a.length()-1, l2 = b.length()-1;
        int flag = 0;//进位
        while(l1>=0||l2>=0||flag>0){
            int tmp = flag;
            if(l1>=0)
                tmp += a.charAt(l1--) - '0';
            if(l2>=0)
                tmp += b.charAt(l2--) - '0';
            flag = tmp>1?1:0;
            str.append(tmp%2);
        }
        return str.reverse().toString();
    }
}
