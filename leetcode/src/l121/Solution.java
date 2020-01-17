package l121;


/**
 * 描述：121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * @Author shf
 * @Date 2019/9/11 15:09
 * @Version V1.0
 **/
public class Solution {
    /**
     * 暴力法
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i=0; i< prices.length - 1; i++){
            for (int j = i + 1; j< prices.length; j++){
                if(prices[j] - prices[i] > max){
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    /**
     * 动态规划法
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices){
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i=0; i< prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > max){
                max = prices[i] -min;
            }
        }
        return max;
    }
    public static int maxProfit2(int[] prices){//1买入，0卖出
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
    //最优解--dp
    public static int maxProfit3(int[] prices){
        int dp_i_0 = 0; //利润
        int dp_i_1 = Integer.MIN_VALUE;//成本
        for(int price : prices){
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);//dp_i_1 + price : 假如今天卖出去可得利润
            dp_i_1 = Math.max(dp_i_1, -price);//-price : 假如今天买入，成本
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
//        int[] aa = {7,6,4,3,1};
//        System.out.println(maxProfit2(aa));
        int[] bb = {7,1,5,3,6,4};
        System.out.println(maxProfit3(bb));
    }


}
/**
 刷动态规划 #121. 买卖股票的最佳时机
 1，暴力法没什么好说的，循环两遍，时间复杂度O(n^2)
 2，动态规划思路：
    （1）缓存一个最小值，初始化最小值设为Integer.max。缓存一个最大值（即返回值）
    （2）首先判断当前值cur是不是最小的，如果是最小的，替换缓存的最小值min，
        如果大于最小值，判断 cur-min > max，如果大于max，则更新max。
    （3）最重要的一个思路是找到最小值后面的最大值，该最小值不一定是整个数组中最小的，
        但是我们可以通过后面的判断保证当前最小值和当前值之间的差值是最大的
  */
