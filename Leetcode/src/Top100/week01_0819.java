package Top100;

import java.util.*;

public class week01_0819 {

    //001 todo：两数之和

    /**
     * 先排序前后遍历找满足的值，再遍历一次找下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] tmp = new int[2];
        if (nums == null || nums.length < 2) {
            return tmp;
        }
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (target < arr[i] + arr[j]) {
                j--;
            } else if (target > arr[i] + arr[j]) {
                i++;
            } else {
                tmp[0] = arr[i];
                tmp[1] = arr[j];
                break;
            }
        }
        boolean flag1 = false, flag2 = false;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == tmp[0]) {
                tmp[0] = k;
                flag1 = true;
            } else if (nums[k] == tmp[1]) {
                tmp[1] = k;
                flag2 = true;
            }
            if (flag1 && flag2) {
                break;
            }
        }
        return tmp;
    }

    /**
     * 最简单是两重循环，不考虑
     * twoSum2是用HashMap保存每次访问的数和下标，判断target-arr[i]是否在HashMap中
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                arr[0] = map.get(target - nums[i]);
                arr[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return arr;
    }

    //002 TODO：（链表表示的）两数相加

    /**
     * 两个非空的链表用来表示两个非负的整数，将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 2->4->3表示342
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int num = 0;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + num;
            if (tmp > 9) {
                cur.next = new ListNode(tmp - 10);
                num = 1;
            } else {
                cur.next = new ListNode(tmp);
                num = 0;
            }
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        //l1或l2还没完
        if (l1 != null) {
            cur.next = l1;
            while (num == 1 && l1.next != null) {
                if (l1.val + num > 9) {
                    l1.val = l1.val + num - 10;
                    num = 1;
                } else {
                    l1.val = l1.val + num;
                    num = 0;
                }
                l1 = l1.next;
            }
            if (num == 1 && l1.next == null) {
                if (l1.val + num > 9) {
                    l1.next = new ListNode(1);
                    l1.val = l1.val + num - 10;
                } else {
                    l1.val = l1.val + 1;
                }
            }
        }

        if (l2 != null) {
            cur.next = l2;
            while (num == 1 && l2.next != null) {
                if (l2.val + num > 9) {
                    l2.val = l2.val + num - 10;
                    num = 1;
                } else {
                    l2.val = l2.val + num;
                    num = 0;
                }
                l2 = l2.next;
            }
            if (num == 1 && l2.next == null) {
                if (l2.val + num > 9) {
                    l2.val = l2.val + num - 10;
                    l2.next = new ListNode(1);
                } else {
                    l2.val = l2.val + 1;
                }
            }
        }
        //[5]+[5]=>[0,1]
        if (l1 == null && l2 == null && num == 1) {
            cur.next = new ListNode(1);
        }
        return result.next;
    }

    /**
     * 优秀的写法
     * https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_super(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    /**
     * 两个非空的链表用来表示两个非负的整数，将这两个数相加起来，则会返回一个新的链表来表示它们的和
     * 数字最高位位于链表开始位置
     * 链表翻转，再相加，再翻转
     * 或者借助两个栈
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode l1_reverse = reverseList(l1);
        ListNode l2_reverse = reverseList(l2);
        return addTwoNumbers(l1_reverse, l2_reverse);
    }

    public ListNode reverseList(ListNode list) {
        ListNode cur = list;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
//        ListNode head = prev;
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
        return prev;
    }

    // 003 TODO：最长无重复子串

    /**
     * 无重复字符的最长子串的长度
     * 修改版是只维护滑动窗口最左下标
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max_length = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap(s.length());
        char[] carr = s.toCharArray();
        for (int i = 0; i < carr.length; i++) {
            if (!map.containsKey(carr[i])) {
                map.put(carr[i], i);
            } else {
                left = Math.max(left, map.get(carr[i]) + 1);
                map.put(carr[i], i);
                System.out.println("left:" + left);
            }
            max_length = Math.max(max_length, i - left + 1);
        }
        return max_length;
    }
    // 005 todo：最长回文子串

    /**
     * 最长回文子串
     * 中心向两侧
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        int max_length = 0, left = 0;
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            int k = 0;
            while (i - k >= 0 && i + k < arr.length) {// 奇2k+1
                if (arr[i - k] == arr[i + k]) {
                    length = 2 * k + 1;
                    k++;
                } else {
                    break;
                }
            }
            if (length > max_length) {
                max_length = length;
                left = i - length / 2;
            }
            int k1 = 0;
            while (i - k1 >= 0 && i + 1 + k1 < arr.length) {// 偶2(k1+1)
                if (arr[i - k1] != arr[i + 1 + k1]) {
                    break;
                }
                length = 2 * k1 + 2;
                k1++;
            }
            if (length > max_length) {
                max_length = length;
                left = i - length / 2 + 1;
            }
        }
        return s.substring(left, left + max_length);
    }

    // 010 （待做）todo：正则匹配

    // 011 todo：盛水最多的容器 双指针
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // 015 todo：三数之和
    // 如下写的有问题，双指针不应该是在双指针中遍历，不好确定双指针到底该向左还是向右移动
    // 像[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]，会漏掉-2，-2，4
    /*public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int tmp = nums[left] + nums[right];
            System.out.println(left+"-"+right);
            for (int i = left + 1; i < right; i++) {
                if (nums[i] + tmp == 0) {
                    ArrayList<Integer> arrayList = new ArrayList<>(1);
                    arrayList.add(nums[left]);
                    arrayList.add(nums[i]);
                    arrayList.add(nums[right]);
                    list.add(arrayList);
                    System.out.println(left+"-"+i+"-"+right);
                    break;
                }
            }
            if (tmp < 0) {
                left++;
                while (left<right-1&&nums[left] == nums[left - 1]) {
                    left++;
                }
            } else {
                right--;
                while (right>left+1&&nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
        return list;
    }*/

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (tmp + nums[i] > 0) {
                    right--;
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (tmp + nums[i] < 0) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return list;
    }
    // 259 todo：三数之和较小值

    /**
     * Given an array of n integers nums and a target,
     * find the number of index triplets i, j, k with 0 <= i < j < k < n
     * that satisfy the condition nums[i] + nums[j] + nums[k] < target
     *
     * @param nums
     * @return n种结果
     */
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp < target) {
                    // left～right中都能满足该条件
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
    // 059 （待做） todo：最接近的三数之和
    // https://leetcode-cn.com/problems/3sum-closest/

    // 017 todo：电话号码的字母组合

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        String[] sarr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] carr = digits.toCharArray();
        for (char c : carr) {
            String tmp = sarr[c - '0' - 2];
            list = addCharToString(tmp, list);
        }
        return list;
    }

    public List<String> addCharToString(String str, List<String> list) {
        List<String> tmp = new ArrayList<>();
        if (list.isEmpty()) {
            for (int i = 0; i < str.length(); i++) {
                tmp.add(str.substring(i, i + 1));
            }
        } else {
            for (String s : list) {
                for (char c : str.toCharArray()) {
                    tmp.add(s + c);
                }
            }
        }
        return tmp;
    }

    // 019 todo：删除链表倒数第n个节点
    // 两个指针，一个先走n步
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head, lastN = head;
        while (n > 0 && first != null) {
            n--;
            first = first.next;
        }
        if (first == null) {
            return head.next;
        }
        while (first.next != null) {
            first = first.next;
            lastN = lastN.next;
        }
        lastN.next = lastN.next.next;
        return head;
    }
    // 020 todo：有效的括号

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        char[] carr = s.toCharArray();
        for (char c : carr) {
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && map.get(c).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }
        //还存在栈中有括号没被匹配到的情况
        return stack.isEmpty();
    }
    // 021 todo：合并两个有序链表

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null && l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else if (l1 == null) {
                cur.next = l2;
                break;
            } else {
                cur.next = l1;
                break;
            }
        }
        return head.next;
    }

    // todo：（递归写法）合并两个有序链表
    private ListNode merge2List_Recursive(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge2List_Recursive(l1.next, l2);
            return l1;
        }else {
            l2.next = merge2List_Recursive(l1, l2.next);
            return l2;
        }
    }
    // 023 todo：合并k个有序链表

    public ListNode mergeKLists(ListNode[] lists){
        if (lists == null || lists.length==0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = new ListNode(-1), cur = head;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            // 有必要判断list是否为空
            if(list==null){
                continue;
            }
            minHeap.add(list);
        }
        while(minHeap.size()!=0){
            ListNode tmp = minHeap.poll();
            cur.next = tmp;
            cur = cur.next;
            if (tmp.next!=null){
                minHeap.add(tmp.next);
            }
        }
        return head.next;
    }

    // todo：分治法合并k个有序链表
    private ListNode mergeKLists_super(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return mergeListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeListsHelper(ListNode[] lists, int left, int right) {
        if(left==right){
            return lists[left];
        }
        int mid = left+(right-left)/2;
        ListNode l1 = mergeListsHelper(lists, left, mid);
        ListNode l2 = mergeListsHelper(lists, mid+1, right);
        return merge2List_Recursive(l1, l2);
    }
    // 088 todo：合并两个有序数组
    /**
     * @param nums1 有足够空间保存nums2的元素
     * @param m     nums1中的有效元素
     * @param nums2
     * @param n     nums2中的有效元素
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (nums1[m - 1] <= nums2[0]) {
            System.arraycopy(nums2, 0, nums1, m, n);
            return;
        }
        int[] tmp = Arrays.copyOfRange(nums1, 0, m);
        int i = 0, j = 0, p = 0;
        while (i < tmp.length && j < nums2.length) {
            if (tmp[i] < nums2[j]) {
                nums1[p++] = tmp[i++];
            } else {
                nums1[p++] = nums2[j++];
            }
        }
        if (i < tmp.length) {
            System.arraycopy(tmp, i, nums1, p, tmp.length - i);
        }
        if (j < nums2.length) {
            System.arraycopy(nums2, j, nums1, p, nums2.length - j);
        }
    }
    // 题目给出是nums1有足够空间，考虑从后往前填位
    public void merge_super(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (nums1[m - 1] <= nums2[0]) {
            System.arraycopy(nums2, 0, nums1, m, n);
            return;
        }
        int p = m+n-1, p1 = m-1, p2 = n-1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        // 只有nums2还有剩余需要考虑
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }

    // 148 （待做）todo：排序链表

    // 022 todo：括号生成
    /**
     * 生成含n对有效括号的所有可能组合
     *
     * @param n
     * @return
     */
    private List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return list;
        }
        StringBuilder stb = new StringBuilder();
        stb.append("(");
        backtrack(stb,n-1,n);
        return list;
    }

    public void backtrack(StringBuilder stb, int ln, int rn) {
        if (rn < ln) {
            return;
        }
        if (ln == 0 && rn == 0) {
            list.add(stb.toString());
            return;
        }
        if (ln > 0) {
            stb.append("(");
            backtrack(stb,ln-1,rn);
            stb.deleteCharAt(stb.length() - 1);
        }
        if (rn > 0) {
            stb.append(")");
            backtrack(stb,ln,rn-1);
            stb.deleteCharAt(stb.length() - 1);
        }
    }
    // 031 todo：下一个排列

    /**
     * 将给定数字序列重新排列成字典序中**下一个更大**的排列（像124231->124321）
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）
     * 必须原地修改，只允许使用额外常数空间
     *
     * @param nums
     */

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <=1) {
            return;
        }
        int i = nums.length-1;
        System.out.println(Arrays.toString(nums));
        while(i>0&&nums[i-1]>=nums[i]){
            i--;
        }
        System.out.println("i:"+i);
        // 原序列是最大字典序排列，则翻转
        if(i==0){
            // 可以直接排序 Arrays.sort(nums);
            reverse(nums,0,nums.length-1);
        }// 原序列是最小字典序排列，交换最后两个数即可
        else if(i==nums.length-1){
            int tmp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = tmp;
        }else {
            // 这里i再自减，因为上面循环写法有不足
            i--;
            int j = i+1;
            // 再下标i之后的序列中找到比nums[i]稍大一点的数，两两交换
            while(j<nums.length&&nums[j]>nums[i]){
                j++;
            }
            System.out.println("j:"+j);
            int tmp = nums[i];
            nums[i] = nums[j-1];
            nums[j-1] = tmp;
            // 再翻转下标i之后的序列
            // 也是可以直接排序 Arrays.sort(nums,i+1,nums.length);
            reverse(nums,i+1,nums.length-1);
        }
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
    // 032 todo：最长有效括号

    public int longestValidParentheses(String s){
        int maxLength = 0;

        return maxLength;
    }
    // 046 （待做）todo：全排列
    // 047 （待做）todo：全排列二
    public static void main(String[] args) {
        week01_0819 p = new week01_0819();
//        int[] arr = new int[]{3, 1};
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 1)));// output:3
//        ListNode list = new ListNode(0);
//        ListNode cur = list;
//        for(int i:arr){
//            cur.next = new ListNode(i);
//            cur = cur.next;
//        }
//        ListNode head = p.reverseList(list);
//        System.out.println(p.lengthOfLongestSubstring("tmmzuxt"));
//        System.out.println(p.longestPalindrome("babad"));
//        List<List<Integer>> lists = p.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
//        for(List<Integer> l:lists){
//            System.out.println(l.toString());
//        }
//        System.out.println(p.letterCombinations("233"));
//        System.out.println(p.isValid("]["));
//        List<String> result = p.generateParenthesis(3);
//        for (String s : result) {
//            System.out.println(s);
//        }
        int[] nums = {1, 2, 4, 3, 1};
        p.nextPermutation(nums);
    }
}

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}