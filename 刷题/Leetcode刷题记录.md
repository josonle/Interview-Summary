## 190429

### 两数之和系列

- Topic1：https://leetcode-cn.com/problems/two-sum/
   - 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标

* Topic167：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     * 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。 函数应该返回这两个下标值 index1 和 index2，其中index1 必须小于 index2
 * Topic657:https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
      * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。

>思路：
>
>- 遍历一次数组，用HashSet保留访问过的数据`arr[j]`，判断`target-arr[i]`是否在HashSet中
>- 数组排序，前后遍历通过`arr[i]+arr[j]`和`target`的大小关系可以可控制下标移动
>
>二叉树那个也是通过在遍历二叉树时把访问的数据放入hashset中，用第一种思路；或者先中序遍历得到有序数组，用第二种思路

* Topic560：https://leetcode-cn.com/problems/subarray-sum-equals-k/
  * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数

> 思路：
>
> 参考别人写的，`P[i]= a0+a1+...+ai`,`P[j]= a0+a1+...+aj`,如果`k=P[j]-P[i]`,说明`ai+1~aj`的子数组和为k
> 用HashMap，k存当前的P[i],v存P[i]出现的次数(负数会造成同一个P[i]出现多次)
> 还有就是`k=num[i]`的情况，所以要先map.put(0,1)
>
> 
>
> 我自己第一次想的是滑动窗口，不过对于负数出现的情况，还想不通怎么办
>
> ```java
> while(i<=nums.length-1&&j<=nums.length-1) {
> 			if(sum==k) {
> 				count++;
> 				sum -= nums[i++];
> 			}else if (sum<k) {
> 				if(j+1<nums.length) sum += nums[++j];
> 				else break;
> 			}else {
> 				sum -= nums[i++];
> 			}
> 		}
> ```
>
> 

```java
public static int solution1(int[] nums,int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();//k存放P[j],v存放P[j]出现的次数
		map.put(0, 1);
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
			if(map.containsKey(sum-k))
				count += map.get(sum-k);
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		return count;
	}
```

