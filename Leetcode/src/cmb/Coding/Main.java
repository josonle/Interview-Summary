package cmb.Coding;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (i<n){
            arr[i++] = in.nextInt();
        }
        result2(arr);
//        mostSubLength(arr);
//        result1(arr);
    }

    public static int interval(int[] arr){
        Arrays.sort(arr);
        return Math.abs(arr[0] - arr[1]);
    }

    public static void mostSubLength(int[] arr){
        int len = 1;
        for (int i = 0; i < arr.length; i++) {
            for(int j=i+1;j<arr.length;j++){
                int tmpLen = 1;
                int flag = arr[i];
                for(int k=j;k<arr.length;k++){
                    if(arr[k]<=flag){
                        continue;
                    }
                    flag = arr[k];
                    tmpLen++;
                }
                if(len<tmpLen){
                    len = tmpLen;
                }
            }
        }
        System.out.println(len);
    }

    public static void result1(int[] arr){
        Arrays.sort(arr);
        int num = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < 0.9 * arr[j]) {
                    break;
                }
                num++;
            }
        }
        System.out.println(num);
    }

    public static void result2(int[] arr){
        int tmp = Math.abs(arr[1]-arr[0]);
        int m = 0, n = 1;
        for(int i=1;i<arr.length-1;i++){
            if(Math.abs(arr[i+1]-arr[i])<tmp){
                tmp = Math.abs(arr[i+1]-arr[i]);
                m = i;
                n = i+1;
                System.out.println("min:"+arr[i]);
            }
        }
        System.out.print(arr[m]+" "+arr[n]);
    }

}
