package l309;

/**
 * 描述：309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 *
 * @Author shf
 * @Date 2020/1/17 11:11
 * @Version V1.0
 **/
public class Solution {
    // [1,2,3,0,2]
    public int maxProfit(int[] prices) {
        int dp_i_0 = 0;//利润
        int dp_i_1 = Integer.MIN_VALUE;//成本
        int dp_pre_0 = 0;//前一次的利润
        for (int price : prices){
            int temp = dp_i_0;//记录当前利润
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);//dp_i_1 + price：如果卖出，可得利润
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - price);//dp_pre_0 - price：如果买入，需要用前一次的利润来计算。隔一次
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
