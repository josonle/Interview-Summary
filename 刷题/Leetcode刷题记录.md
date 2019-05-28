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

### Long转int
```
Long a = 123L;
int b = a.intValue();
```
## 190430

## 190501

## 190502
### 回文系列
- Topic
    - 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
	  说明：本题中，我们将空字符串定义为有效的回文串。
- Topic680：https://leetcode-cn.com/problems/valid-palindrome-ii/
    * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
- Topic9：https://leetcode-cn.com/problems/palindrome-number/
    * 判断一个整数是否是回文数，进阶：不转为字符串怎么做
- Topic234：https://leetcode-cn.com/problems/palindrome-linked-list/
    * 判断回文链表，能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题
> 思路就是前后遍历，判断是否相等。数字可以转字符串，也可以进行int变换`result = tmp%10+result*10`后判断两数相等否。单链表先找中点，再旋转后半段链表之后判断回文。删一个字符的就是增加一个flag标志用以判断不等时去掉一个字符的子字符串是否相等`solution3(s.substring(i, j))||solution3(s.substring(i+1,j+1))`

## 涉及排序数组

- Topic34 <https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/>

在排序数组中查找元素的第一和最后一个出现的位置
> 就是二分查找，找到后在前后遍历找出起点终点，再break跳出

- Topic80 <https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/>

删除排序数组中的重复项 II
> O(n)，通过newLen控制新数组中元素，count保证重复元素不超过两个

## 涉及旋转数组类别

- Topic33 <https://leetcode-cn.com/problems/search-in-rotated-sorted-array/>

搜索旋转排序数组I 

- Topic81 <https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/>

搜索旋转排序数组II


- Topic153 <https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/>

寻找旋转排序数组中的最小值I 【数组无重复数据】

- 

> - 旋转排序数组有个特点，从中点划分一定是一半有序，一半无序。无序的一半继续划分一半也是一半有序一半无序
  - 所以可以用二分法查找，但是有一点要注意，**允不允许重复元素**。允许出现重复时，像1,3,1,1,1这种查找3时不能仅仅凭借二分，因为nums[0]=nums[2]，你无法判断是在mid左侧还是右侧查找，所以考虑相等时i++处理

## 涉及回溯算法

[39.组合总和](https://leetcode-cn.com/problems/combination-sum/)

[40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/)

[46. 全排列](https://leetcode-cn.com/problems/permutations/)

[47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)

[78. 子集](https://leetcode-cn.com/problems/subsets/)

[90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/)

这类题目都是同一类型的,用回溯算法!

其实回溯算法关键在于:不合适就退回上一步

然后通过约束条件, 减少时间复杂度.


### tips
- ASCII码：字符0是48，A是65，a是97
`‘A’+32`输出并非’a‘，因为会向上转型为int，所以要强制转为char，即`(char)('A'+32)`

- `List<List<Integer>> list`，向list中添加一个List不能list.add(List)
```java
List<List<Integer>> list = new ArrayList<>();
List<Integer> l1 = new ArrayList<>();
list.add(l1);//error，这样只是添加了l1的引用，后续修改l1时，值会变
list.add(new ArrayList<>(l1));//OK
```