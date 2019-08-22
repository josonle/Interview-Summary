package cmb.Coding;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args){
        int[] arr = {2, 3, 4, 1, 2};
        System.out.println(result(arr));
    }
    public static int result(int[] arr){
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for(int i=0;i<arr.length;i++){
            int tmp = arr[arr[i]];
            int j = arr[i];
            if (tmp == arr[i]&&i!=tmp) {
                return tmp;
            }
            arr[i] = tmp;
            arr[j] = j;
            System.out.println(Arrays.toString(arr));
        }
        return -1;
    }
}
