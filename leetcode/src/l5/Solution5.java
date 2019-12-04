package l5;


/**
 * 描述：5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 思路：
 * 1，三个变量，l记录最长回文串的左边界，r右边界，max记录最大长度
 * 2，dp记录相等的两个元素的位置
 * 3，双层循环遍历，当j==i位置的元素，且j - i < 3一定是回文串，如：aa,或者aba
 * 4，当j == i位置的元素，且dp[i + 1][j - 1]为true，即可判断其内部子串是回文串（动态规划的问题分解）
 * 5，最终返回：s.substring(l, r + 1);
 *
 * @Author shf
 * @Date 2019/12/3 21:42
 * @Version V1.0
 **/
public class Solution5 {
    public static String longestPalindrome(String s) {
        if(null == s || s.length() == 0) return s;
        int l = 0, r = 0, max = 0, n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=n-1; i>=0; i--){
            dp[i][i] = true;
            for(int j=i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    if(max < j - i){
                        max = j - i;
                        l = i;
                        r = j;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("cccccc"));
        System.out.println(longestPalindrome("abacab"));
//        System.out.println(longestPalindrome("abcda"));
        System.out.println("abcdefg".substring(1, 3 + 1));
    }
}
