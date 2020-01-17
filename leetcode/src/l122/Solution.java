package l122;

/**
 * 描述：122. 买卖股票的最佳时机 II
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 思路：
 * 7    o
 * 6                    o
 * 5             o
 * 4                         o
 * 3                 o
 * 2         o
 * 0    1    2   3   4   5   6
 * @Author shf
 * @Date 2019/10/28 21:17
 * @Version V1.0
 **/
public class Solution {
    //波峰波谷
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i + 1] - prices[i] > 0){
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }
    //动态规划
    public static int maxProfit1(int[] prices) {
        int dp_i_0 = 0;//利润
        int dp_i_1 = Integer.MIN_VALUE;//成本
        for(int price : prices){
            int temp = dp_i_0;//记录之前的利润
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);//dp_i_1 + price: 如果本次卖出,可得利润。
            dp_i_1 = Math.max(dp_i_1, temp - price);//temp - price: 如果本次买入，需要付出的成本。这里应该有一个悖论：如果一天适合买入，则一定不适合卖出。
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
//        int[] arr = {1, 2, 3, 4, 5};
        int i = maxProfit1(arr);
        System.out.println(i);
    }
}
