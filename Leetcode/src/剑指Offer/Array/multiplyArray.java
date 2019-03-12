package 剑指Offer.Array;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author josonlee
 * @title 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 * (就是少了A[i])
 * 
 * 两步走，B[i] = A[0]*...*A[i-1]，B[i] = B[i]*A[i+1]*...*A[n-1]。其实就是利用二维数组遍历
 */
public class multiplyArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
		multiply(a);
	}
	public static int[] multiply(int[] A) {
        int len = A.length;
        ArrayList<Integer> arr = new ArrayList<Integer>(len);
        //A[0]*...*A[i-1]
        int tmp = 1;
        for(int i=0;i<len;tmp*=A[i++]){
            arr.add(i,tmp);
        }
        tmp = 1;
        //A[i+1]*...*A[n-1]
        for(int i=len-1;i>=0;tmp*=A[i--]){
        	System.out.println("old is "+arr.toString());
            arr.set(i,arr.get(i)*tmp);
            System.out.println(arr.toString());
        }
        int[] a = new int[len];
        for(int i=0;i<len;i++){
            a[i] = arr.get(i);
        }
        System.out.println(Arrays.toString(a));
        return a;
    }
}
