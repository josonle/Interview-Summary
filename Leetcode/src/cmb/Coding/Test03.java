package cmb.Coding;

public class Test03 {
    public static void main(String[] args) {
        String str = "asd asdf as df   adsf ";
        System.out.println("result(str) = " + result(str));
    }

    public static String result(String str){
        if(str==null){
            return str;
        }

        return  str.replaceAll(" ", "%20");
    }
}
