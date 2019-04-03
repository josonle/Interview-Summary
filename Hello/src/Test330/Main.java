package Test330;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author josonlee
 * 输入数组大小k，和一行k个数据（空格隔开），可以把第一个元素移动到最后一个位置
 * 找出|a1-1|+|a2-2|+...+|ak-k|的最小值（ai表示第i个数据）
 * 例如输入
 * 5
 * 5 4 3 2 1
 * 输出 6
 */
public class Main {

	public static void main(String[] args) throws IOException {
		int k = System.in.read()-'0';
		int[] arr = new int[k];
		int count = 0;
		for(int i=0;i<2*k;i++) {
			char ch = (char)System.in.read();
			if(ch==' '||ch=='\n')
				continue;
			else {
				arr[count] = ch-'0';
				count++;
			}
		}
		System.out.println(Arrays.toString(arr));
		solution(arr);
	}
	public static void solution(int[] arr) {
		int len = arr.length;
		
		int count = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<len;i++) {
			int sum = 0;
			for(int j = i-count;j<len;j++) {
				if(j+count<len) {
					sum += Math.abs(arr[j+count]-j-1);
					System.out.println(arr[j+count]+"->abs :"+(arr[j+count]-j-1));
				}
				else {
					sum += Math.abs(arr[j+count-len]-j-1);
					System.out.println("--"+arr[j+count-len]+"->abs :"+(arr[j+count-len]-j-1));
				}
			}
			System.out.println("sum is"+sum);
			if(sum<min) {
				min = sum;
			}
			count++;
		}
		System.out.println(min);
	}
}
