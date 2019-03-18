package 剑指Offer.Array;

import java.util.Map;
import java.util.HashMap;
/**
 * @author josonlee
 * @title 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。
 * 
 * 我想法就是用HashMap存储起来
 * 
 * 剑指上是用(异或^)来做，偶数次出现的异或为0，最后异或结果位与操作找最后一位1，再依次和数组中数组异或，零和不为零分两组
 */
public class FindNumsAppearOnce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1^3);
	}
	public static void findNums(int[] array,int num1[],int num2[]) {
		int sum = 0;
		for (int i : array) {
			sum ^= i;//异或
		}
		int length = array.length;
		int len = 0;
		for(;len<length;len++) {
			if((sum&(1<<len))!=0)//1左移len长，找到最后一个1
				break;
		}
		for (int i : array) {
			if((i&(1<<len))==0) {//分两组，一组是该位置为1，一组为0
				num1[0] ^= i;
			}else {
				num2[0] ^= i;
			}
		}
	}
	public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i:array){
            int tmp = map.getOrDefault(i,0);
            if(tmp==0){
                map.put(i,1);
            }else{
                map.put(i,++tmp);
            }
        }
        int i = 0;
        int num[] = new int[2];
        for(Map.Entry<Integer,Integer> item:map.entrySet()){
            int val = item.getValue();
            if(val%2==1){
                num[i] = item.getKey();
                i++;
            }
        }
        num1[0] = num[0];
        num2[0] = num[1];
    }
}
