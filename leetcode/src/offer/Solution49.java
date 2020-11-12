package offer;

/**
 * 描述：剑指 Offer 49. 丑数
 *
 * @Author shf
 * @Date 2020/6/27 20:21
 * @Version V1.0
 **/
public class Solution49 {
    public static int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i< n; i++){
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if(dp[i] == dp[p2] * 2) p2 ++;
            if(dp[i] == dp[p3] * 3) p3 ++;
            if(dp[i] == dp[p5] * 5) p5 ++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    //1 - 1, 1
    //2 - 2, 2*1
    //3 - 3, 3*1
    //4 - 4, 2*2
    //5 - 5, 5*1
    //6 - 6, 3*2
    //7 - 8, 2*2*2
    //8 - 9, pow(3, 2)
    //9 - 10,2 * pow(5, 1)
    //10- 12,pow(2, 3) + 2 * pow(2, 1)
}
