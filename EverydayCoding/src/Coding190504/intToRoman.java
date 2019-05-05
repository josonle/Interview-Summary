package Coding190504;

import java.util.HashMap;

/**
 * @author josonlee
 * Topic12：https://leetcode-cn.com/problems/integer-to-roman/
 * int转罗马数字，罗马数字包含以下七种字符： I， V， X， L，C，D 和 M分别对应1,5,10,50,100，500和1000。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * 思路：像2000不是IIM，而是MM，类似2000是20个M，所以从最大的数开始求余即可
 * 
 * 
 * Topic13：https://leetcode-cn.com/problems/roman-to-integer/
 * 罗马数转int，情况同上
 */
public class intToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(toRomanSolution(58));
		System.out.println(toIntSolution("IV"));
	}
	/**
	 * 
	 * @param num
	 * @return
	 */
	public static String toRomanSolution(int num) {
		int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String roman[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        if(num<=0)
        	return null;
        int i=0;
        String result = "";
        while(num>0) {
        	int tmp = num/values[i];
        	if(tmp>0) {
        		num = num-tmp*values[i];
        		while(tmp>0) {
        			result += roman[i];
        			tmp--;
        		}
        	}
        	i++;
        }
        return result;
	}
	
	public static int toIntSolution(String str) {
		if(str.length()==0||str==null)
			return 0;
		int values[]={1000,500,100,50,10,5,1};
        String roman ="MDCLXVI";
        int result = 0;
        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++) {
        	int index = roman.indexOf(arr[i]);
        	if(i+1<arr.length) {//判断下一个是否会构成类似IV这种
        		String tmp = str.substring(i, i+2);
        		System.out.println(tmp);
        		switch (tmp) {
				case "IV":
					result += 4;
					i++;
					System.out.println(result+"_"+i);
					break;
				case "IX":
					result += 9;
					break;
				case "XL":
					result += 40;
					break;
				case "XC":
					result += 90;
					break;
				case "CD":
					result += 400;
					break;
				case "CM":
					result += 900;
					break;
				default:
					result += values[index];
					break;
				}
        	}else {//没有下一个字符
        		result += values[index];
			}
        }
        return result;
	}
}
