package Coding190504;

/**
 * @author josonlee
 * Topic11：https://leetcode-cn.com/problems/container-with-most-water/
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * n>=2,且容器不能倾斜
 */
public class maxArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
		System.out.println(maxArea_dynamic(height));
	}
	/**
	 * 双层循环，时间复杂度O(n^2)
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
        int area = 0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
            	int h = Math.min(height[i], height[j]);
            	int space = (j-i)*h;
                if(area<space)
                	area = space;
            }
        }
        return area;
    }
	/**
	 * 思路来自之前两数之和，双指针前后遍历，时间复杂度O(n)
	 * @param height
	 * @return
	 */
	public static int maxArea_dynamic(int[] height) {
		int area = 0;
		int i = 0,j = height.length-1;
		while(i<j) {
			int h = Math.min(height[i], height[j]);
			int space = (j-i)*h;
			if(space>area)
				area = space;
			//因为h是取最小的，移动指针是为了找到和当前最高的h接近。比如height[1]=3,height[7]=6,肯定是期望height[4]比height[3]接近height[7]
			if(height[i]<height[j])
				i++;
			else 
				j--;
		}
		return area;
	}
}
