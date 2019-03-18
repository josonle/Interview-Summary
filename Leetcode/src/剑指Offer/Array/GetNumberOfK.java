package 剑指Offer.Array;

/**
 * @author josonlee
 * @title 统计一个数字在已排序数组中出现的次数
 */
public class GetNumberOfK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,1,3,3,3,3};
		System.out.println(getNumberOfK(arr, 2	));
	}

	public static int getNumberOfK(int [] array , int k) {
	       if(array==null||array.length==0)
	           return 0;
	        if(k<array[0]||k>array[array.length-1])
	            return 0;
	        int low = 0,high = array.length-1;
	        int last = findLastK(array, low, high, k);
	        return last==-1?0: last - findFirstK(array, low, high, k)+1;//-1表示没有该数
	    }
	    public static int findFirstK(int[] array,int i,int j,int k){
	        while(i<=j){
	        	int mid = (i+j)/2;
	            if(array[mid]<k){
	                i = mid + 1;
	            }else if(array[mid]>k){
	                j = mid -1;
	            }else {
					if((mid>0&&array[mid-1]!=k)||mid==0) {
						return mid;
					}else {
						j = mid -1;
					}
				}
	        }
	        return -1;
	    }
	    public static int findLastK(int[] array,int i,int j,int k){
	        while(i<=j){
	        	int mid = (i+j)/2;
	            if(array[mid]<k){
	                i = mid + 1;
	            }else if(array[mid]>k){
	                j = mid -1;
	            }else {
					if((mid<j&&array[mid+1]!=k)||mid==j) {
						return mid;
					}else {
						i = mid +1;
					}
				}
	        }
	        return -1;
	    }
}
