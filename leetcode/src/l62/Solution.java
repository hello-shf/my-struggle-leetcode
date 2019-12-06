package l62;

/**
 * 描述：62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * 思路：
 * 1，dp记录曾经走过的位置路径数，（m+1,n+1防数组越界）
 * 2，因为只能向右或者向下，即对应正循环。
 * 3，每走过一个格子，可选的路径数=左格子 + 上格子（dp的问题分解）
 * 4，经过3步骤，如果=0 即他处在边界上，边界上的可选路径总为1。（利用int数组的初始值为0）
 * @Author shf
 * @Date 2019/12/6 10:04
 * @Version V1.0
 **/
public class Solution {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if(dp[i][j] == 0){
                    dp[i][j] = 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }
}
