package Coding190501;

/**
 * @author josonlee Topic：https://leetcode-cn.com/problems/zigzag-conversion/
 *         Z字形变换，将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 比如输入字符串为
 *         "LEETCODEISHIRING" 行数为 3 时
 *         之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class convertZ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "LEETCODEISHIRING";
		int n = 2;
//		 System.out.println(convert(s, n));
		 System.out.println(convert("     ", 1));
	}

	public static String convert(String s, int n) {
		if(s==null)
            return null;
        if(s.length()==0)
            return "";
        if(s.length()==1||n==1)
			return s;
        	
		int k = 0;
		//判断二维数组有k列
		if (s.length() % (2 * n - 2) < n) {
			if (s.length() % (2 * n - 2) == 0)
				k = (n - 1) * (s.length() / (2 * n - 2));
			else
				k = (n - 1) * (s.length() / (2 * n - 2)) + 1;
		} else {
			k = (n - 1) * (s.length() / (2 * n - 2)) + s.length() % (2 * n - 2) - n + 1;
		}
		System.out.println(k);
		int[][] arr = new int[n][k];//插入的是字符下标
		System.out.println(k);
		int row = 0;//
		int col = 0;//
		boolean flag = true;// true是一竖
		for (int i = 0; i < s.length(); i++) {
			if (flag) {// 一竖
				System.out.println(row + "-" + col + "-" + i);
				arr[row++][col] = i;
				if (row == n) {
					flag = false;
					row = n - 1;
				}
			} else {// 一撇
				arr[--row][++col] = i;
				System.out.println(row + "-" + col + "-" + i);
				if (row == 0) {
					flag = true;
					row++;
				}
			}
		}
		StringBuffer stb = new StringBuffer();
		stb.append(s.charAt(0));
		System.out.print(0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				if (arr[i][j] != 0) {
					stb.append(s.charAt(arr[i][j]));
					// System.out.print(","+arr[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
		return stb.toString();
	}
	//参考别人的
	public String convert2(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        int space = (numRows - 1) * 2;
        
        char[] chars = s.toCharArray();
        char[] newchars = new char[chars.length];

        int i = 0;
        for(int row = 1; row <= numRows; row++) {
                int start = row - 1;
                int start2 = 2 * numRows - row - 1;
                while(start < chars.length) {
                    newchars[i] = chars[start];
                    start += space;
                    i++;
                    if(row != 1 && row != numRows) {
                        if(start2 < chars.length) {
                            newchars[i] = chars[start2];
                            start2 += space;
                            i++;
                        }
                    }
                }
        }
        return new String(newchars);
    }
}
