package cmb.Coding;

import java.util.Arrays;

public class Test05 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,9,20,15,17};
        int[] arrCopy = Arrays.copyOf(arr, 3);
        int[] arrCopy1 = Arrays.copyOfRange(arr, 1, 2);
        System.out.println(Arrays.toString(arrCopy));
        System.out.println(Arrays.toString(arrCopy1));
    }
}
