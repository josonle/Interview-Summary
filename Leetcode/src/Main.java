import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.printf("%.2f", result(arr));
//        System.out.printf("%.2f",variance(10,17,17));
    }

    public static double result(int[] arr){
        if (arr == null || arr.length < 3) {
            return -1;
        }
        Arrays.sort(arr);
        double min_variance = Double.MAX_VALUE;
        // 离均值最进的三个数方差最小
        for (int i = 0; i < arr.length-2; i++) {
            double tmp = variance(arr[i], arr[i + 1], arr[i + 2]);
            min_variance = tmp<min_variance?tmp:min_variance;
        }
        return min_variance;
    }

    public static double variance(int a, int b, int c) {
        double mean = (a+b+c)/3.0;
        return (Math.pow(a-mean,2)+Math.pow(b-mean,2)+Math.pow(c-mean,2))/3;
    }

    public static int min_length(int[] arr) {
        if (arr == null || arr.length < 3) {
            return -1;
        }
        Arrays.sort(arr);
        return 0;
    }
}