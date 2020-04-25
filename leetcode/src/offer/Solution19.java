package offer;

/**
 * 描述：19 正则匹配
 *
 * @Author shf
 * @Date 2019/11/29 17:12
 * @Version V1.0
 **/
public class Solution19 {
    public static boolean isMatch(String str, String pattern) {
        if(str == null || pattern == null)
            return false;
        if(str.length() == 0 && pattern.length() == 0){
            return false;
        }
        return matchChar(str.toCharArray(), 0, pattern.toCharArray(), 0);
    }
    public static boolean matchChar(char[] str, int s, char[] pattern, int p){
        if(s == str.length && p == pattern.length){
            return true;
        }else if((s == str.length && p != pattern.length) || (s != str.length && p == pattern.length)){
            return false;
        }
        if(str[s] == pattern[p] || pattern[p] == '.'){
            return matchChar(str, ++s, pattern, ++p);
        } else if(pattern[p] == '*'){
            if(p == 0){
                return false;
            } else{
                while (s < str.length - 1 && str[s] == str[s + 1]){
                    s ++;
                }
                return matchChar(str, ++s, pattern, ++p);
            }
        }else if(p < pattern.length - 1 && pattern[p + 1] == '*'){
            return matchChar(str, s, pattern, ++p);
        }else{
            return false;
        }
    }


    public static void main(String[] args) {
        String a = "aab";//"   bbbbb";
        String b = "c*a*b";//"      ba*";
        boolean match = isMatch(a, b);
        System.out.println(match);

        boolean matches = a.matches(b);
        System.out.println(matches);
    }
}
