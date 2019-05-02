package Coding190502;

/**
 * @author josonlee
 *
 */
public class isPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println((char)('A'+32));
//		System.out.println(solution2(""));
//		System.out.println(solution3("ececcec"));
//		System.out.println(solution4(-121));
//		System.out.println(solution5(121));
	}
	/**
	 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
	 * 说明：本题中，我们将空字符串定义为有效的回文串。
	 * "A man, a plan, a canal: Panama" true
	 * @param s
	 * @return
	 * 字符0是48，A的ascii码65，a是97相差32
	 * ascii码转char：int ascii;char c = (char)ascii;
	 */
	public static boolean solution2(String s) {
		if(s==null||s.length()==0)
			return true;
		StringBuffer stb = new StringBuffer();
//		s = s.toLowerCase();//可以直接小写化
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            if((tmp>='0'&&tmp<='9')||(tmp>='a'&&tmp<='z'))
                stb.append(tmp);
            else if(tmp>='A'&&tmp<='Z')
                stb.append((char)(tmp+32));
            else
                continue;
        }
        System.out.println(stb.toString());
		return stb.toString().equals(stb.reverse().toString());
	}
	/**
	 * Topic680：https://leetcode-cn.com/problems/valid-palindrome-ii/
	 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
	 * @param s
	 * @return
	 * 
	 * 思路就是增加一个标志位flag，在回文串判断基础上增加一次不等时判断子串是否是回文串
	 * 像这个ececcec，还要判断是删掉第一个还是最后一个
	 */
	private static boolean flag = true;
	public static boolean solution3(String s) {
		int len = s.length();
		int i,j=len-1;
		for(i=0;i<len/2;i++) {
			if(s.charAt(i)!=s.charAt(j)) {
				System.out.println(flag);
				if(flag==false)//表明已近修改过一次
					return false;
				flag = false;
				return solution3(s.substring(i, j))||solution3(s.substring(i+1,j+1));
			}
			j--;
		}
		return true;
	}
	/**
	 * Topic9：https://leetcode-cn.com/problems/palindrome-number/
	 * 判断一个整数是否是回文数
	 * @param x
	 * @return
	 * 
	 * 进阶：不转为字符串怎么做？
	 */
	public static boolean solution4(int x) {
		if(x<0)
            return false;
        String str = x+"";
        int len = str.length();
        for(int i=0;i<len/2;i++){
            if(str.charAt(i)!=str.charAt(len-i-1))
                return false;
        }
        return true;
	}
	//同上，不过只是int变换
	public static boolean solution5(int x) {
		if(x<0)
			return false;
		if(x<10)
			return true;
		int result = 0, tmp = x;
		while(tmp>0) {
			result = tmp%10 + result*10;
			tmp /=10;
		}
		return result==x;
	}
	/**
	 * Topic234：https://leetcode-cn.com/problems/palindrome-linked-list/
	 * 判断回文链表，能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题
	 * @return
	 * 思路同样，不过是先翻转链表，但翻转只是翻转一半，所以先找中点。当然，双链表就同字符串一样
	 */
//	public static boolean solution6(ListNode head) {
//		if(head==null||head.next==null)
//            return true;
//        
//        ListNode fast = head,slow = head;
//        while(fast!=null&&fast.next!=null){// 找到中点slow
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        if(fast==null){// 偶
//            slow = reverseList(slow);
//        }else{// 奇
//            slow = reverseList(slow.next);
//        }
//        while(slow!=null){
//            if(head.val!=slow.val)
//                return false;
//            head = head.next;
//            slow = slow.next;
//        }
//        return true;
//	}
}
