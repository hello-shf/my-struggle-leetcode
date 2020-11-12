package offer;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/6/21 23:55
 * @Version V1.0
 **/
public class Solution47 {
    public static int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(i == 0 && j == 0) continue;
                else if(i == 0)
                    dp[i][j] += dp[i][j - 1];
                else if(j == 0)
                    dp[i][j] += dp[i - 1][j];
                else
                    dp[i][j] += Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {

    }
}
