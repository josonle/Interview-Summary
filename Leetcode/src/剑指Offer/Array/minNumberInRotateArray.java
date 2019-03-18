package 剑指Offer.Array;

/**
 * @author josonlee
 * @title 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * 本质还是二分查找吧，但分段递增有序
 */
public class minNumberInRotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,4,5,6,1,2,3};
		System.out.println(minNumber(array));
	}
	public static int minNumber(int [] array) {
        if(array.length==0||array==null)
            return 0;
        int low = 0,high = array.length-1;
        while(low<high){
            int mid = (high-low)/2+low;
            if(array[mid]>array[high]){//min一定在右边
                low = mid + 1;
            }else if(array[mid]==array[high]){//因为是非减排序，存在相等，A[mid]=A[high]表明mid到high中都是等于该值
                high = high -1;
            }else{//min一定在左边
                high = mid;
            }
        }
        return array[low];
    }
}
