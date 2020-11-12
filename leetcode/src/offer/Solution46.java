package offer;

/**
 * 描述：
 * 输入: 12258
 *       1 2 2 5 8  bccfi
 *       12 2 5 8   mcfi
 *       1 2 25 8   bczi
 *       1 22 5 8   bwfi
 *       12 25 8    mzi
 *
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * @Author shf
 * @Date 2020/6/21 23:12
 * @Version V1.0
 **/
public class Solution46 {
    public static int translateNum(int num) {
        if(num < 10) return 1;
        int length = String.valueOf(num).length();
        int[] dp = new int[length];
        dp[0] = 1;
        int n1 = num / (int)Math.pow(10, (length - 1)) % 10;
        int n2 = num / (int)Math.pow(10, (length - 2)) % 10;
        dp[1] = n1 * 10 + n2 > 25 ? 1:2;
        for(int i = 2; i<length; i++){
            int pre = num / (int)Math.pow(10, (length - i)) % 10;
            int cur = num / (int)Math.pow(10, (length - i - 1)) % 10;
            if(pre*10 + cur > 25){
                dp[i] = dp[i - 1];
            }else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}
