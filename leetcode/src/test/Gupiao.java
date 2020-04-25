package test;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/1/16 15:37
 * @Version V1.0
 **/
public class Gupiao {
    public static void main(String[] args) {
//        int[] aa = {7,6,4,3,1};
//        System.out.println(maxProfit1(aa));
//        int[] bb = {7,1,5,3,6,4};
//        System.out.println(maxProfitnc(bb));
        int[] bb = {1,2,3,0,2};
        System.out.println(maxProfitnc(bb));
//        int[] bb = {1, 3, 2, 8, 4, 9};
//        System.out.println(maxProfitFee(bb, 2));
    }
/////////////////////////////////////k = 1/////////////////////////////////////////
    public static int maxProfit1(int[] prices){//1买入，0卖出
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
    public static int maxProfit1_1(int[] prices){//1买入，0卖出
        int n = prices.length;
        int dp_i_0 = 0;//利润，即第一次卖出。
        int dp_i_1 = -prices[0];//成本，即第一次买入。
        for(int i=1; i<n; i++){
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);//当前利润，利润=price[i](卖出当前) - 上次买入，所以取之前利润和当前利润的最大收益
            dp_i_1 = Math.max(dp_i_1, -prices[i]);//当前成本，比较两次买入成本决定是否买入。
        }
        return dp_i_0;
    }
    //{7,1,5,3,6,4};
    public static int maxProfit1_2(int[] prices){//1买入，0卖出
        int n = prices.length;
        int dp_i_0 = 0;//利润
        int dp_i_1 = Integer.MIN_VALUE;//成本
        for(int i=0; i<n; i++){
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);//当前利润，利润=price[i](卖出当前) - 上次买入，所以取之前利润和当前利润的最大收益
            dp_i_1 = Math.max(dp_i_1, -prices[i]);//当前成本，比较两次买入成本决定是否买入。
        }
        return dp_i_0;
    }


//////////////////////////////////k = n/////////////////////////////////////
    //int[] bb = {7,1,5,3,6,4};
    public static int maxProfitn(int[] prices){
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            System.out.println("temp=" + temp + ", dp_i_0="  + dp_i_0 + ", dp_i_1=" + dp_i_1);
        }
        return dp_i_0;
    }
//////////////////////////////////k = n 冷却时间/////////////////////////////////////
    // [1,2,3,0,2]
    public static int maxProfitnc(int[] prices){
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
            System.out.println("temp=" + temp + ", dp_pre_0=" + dp_pre_0 + ", dp_i_0="  + dp_i_0 + ", dp_i_1=" + dp_i_1);
        }
        return dp_i_0;
    }
    //////////////////////////////////k = n 手续费/////////////////////////////////////
    //prices = [1, 3, 2, 8, 4, 9], fee = 2
    public static int maxProfitFee(int[] prices, int fee) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }
        return dp_i_0;
    }
    //////////////////////////////////k = 2/////////////////////////////////////
    //3,3,5,0,0,3,1,4
    public int maxProfit2(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }
}
