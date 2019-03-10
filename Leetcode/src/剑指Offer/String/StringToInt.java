package 剑指Offer.String;


public class StringToInt {
	public long strToInt(String str) {
        if(str==null||str.trim().equals(""))
            return 0;
        char[] c = str.toCharArray();
        int flag = (c[0]=='+'||c[0]=='-')? 1:0;//标志+-
        Long sum = (long) 0;
        for(int i=flag;i<c.length;i++){
            if((c[i]-'0')<0||c[i]-'0'>9)
                return 0;
            sum = sum*10+c[i]-'0';
        }
        if (flag==1) {
			sum = c[0]=='+'?sum:-sum;
		}
        return flag==1?(c[0]=='+'?sum:-sum):sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StringToInt().strToInt("+1234561345678879"));
		System.out.println(Long.parseLong("1234561345678879"));
	}

}
