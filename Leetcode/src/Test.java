import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int k = in.nextInt();
//        int[] arr = new int[k];
//        int i = 0;
//        arr[0] = in.nextInt();
//        while (i<k) {
//        	arr[i++] = in.nextInt();
//        }

//        System.out.println(Arrays.toString(result(arr)));
        
//        Long a = in.nextLong();
//        Long b = in.nextLong();
//        System.out.println(getGCD(a, b));
        
        int k = in.nextInt();
        int[] arr = new int[k];
        int i=0;
        while(k>0) {
        	k--;
        	switch (in.nextInt()) {
			case 1:
				arr[i++] = in.nextInt();
				break;
			case 2:
				result1(arr,in.nextInt());
				break;
			default:
				break;
			}
        }
    }
    
    public static int[] result(int[] arr){
        if(arr==null||arr.length==0)
            return arr;
        int[] max = new int[arr.length];
        int maxFlag = Integer.MIN_VALUE;
        int i=0;
        for (int a : arr) {
			if(maxFlag<a) {
				maxFlag = a;
			}
			max[i++] = maxFlag;
		}
        return max;
    }
   
    public static Long getGCD(Long a,Long b) {
    	Long gcd = 0l;
		if(a<b) {
			Long tmp = a;
			a = b;
			b = tmp;
		}
		if(a%b==0)
			return b;
		while(a%b>0) {
			a = a%b;
			if(a<b) {
				Long tmp1 = a;
				a = b;
				b= tmp1;
			}
			if(a%b==0)
				gcd = b;
		}
		return gcd;
	}
    
    public static void result1(int[] arr,int k) {
		int tmpOr,tmpValue;
		for(int i=0;i<Math.pow(2, arr.length);i++) {
			tmpValue = i;
			tmpOr = 0;
			for(int j=0;j<arr.length;j++) {
				if(tmpValue%2==1) {
					tmpOr |= arr[j];
				}
				tmpValue /= 2;
			}
			if(tmpOr==k) {
				tmpValue = i;
				for(int j=0;j<arr.length;j++) {
					if(tmpValue%2==1)
						System.out.println("YES");
					tmpValue /= 2;
				}
			}
		}
    	System.out.println("NO");
	}
}
