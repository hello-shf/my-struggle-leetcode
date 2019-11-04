package l392;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/10/30 20:59
 * @Version V1.0
 **/
public class Solution {
    public static boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        int l = 0;
        int start = 0;//记住上一个相同的位置，下次循环从该位置开始查找
        for(int i=0; i< s.length(); i++){
            for(int j=start; j<t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    start = j + 1;
                    l ++;
                    if(l == s.length()){
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        boolean b = isSubsequence(s, t);
        System.out.println(b);
    }
}
