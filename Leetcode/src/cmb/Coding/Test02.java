package cmb.Coding;

public class Test02 {
    public static void main(String[] args) {
        int[][] arr = new int[4][];
        arr[0] = new int[]{1,2,3,4};
        arr[1] = new int[]{2, 3, 4, 5};
        arr[2] = new int[]{3, 4, 5, 6};
        arr[3] = new int[]{4, 5, 6, 7};
        System.out.println("result(arr,2) = " + result(arr,2));
    }

    public static boolean result(int[][] arr,int k){
        if (arr == null || arr.length == 0) {
            return false;
        }
        int m = arr.length-1;
        int n = 0;
        while (m>=0&&n<arr[0].length){
            if (arr[m][n] == k) {
                return true;
            } else if (arr[m][n] < k) {
                n++;
            } else {
                m--;
            } 
        }
        return false;
    }
}
