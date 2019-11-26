package offer;

/**
 * 描述：剪绳子
 * 给你一根长度为 n 绳子，请把绳子剪成 m 段（m、n 都是整数，2≤n≤58 并且 m≥2）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]k[1] … k[m] 可能的最大乘积是多少？
 * 例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
 *
 * 样例
 * 输入：8
 * 输出：18
 *
 * 适合动态规划的题目：
 * 1，求最大或者最小值
 * 2，能够将大问题分解为若干个子问题
 * 3，整体问题的最优解是依赖各个子问题的最优解
 * 思路：
 * 1，找出最小的子问题，即 当length < 4。不剪就是最优解
 * 2，将大问题分解，当 length >=4 其该大问题总能由其子问题得出最优解
 * 3，每次分割绳子，总分解为两段，即将大问题通过分解递归的找到其最小的子问题即 当绳子长度为1,2,3（最小问题单元）。
 * 4，在整个过程中，大问题不断分解的过程中，总会重复的计算分解的小问题，此时需要将子问题缓存起来，避免重复计算。
 *
 * 比如绳子长度为8，从长度4开始，计算当绳子长度为4,5,6,7的时候的最优解，
 * 然后将绳子8不断的分为两段，计算每种分割方法的解，比较得出最优解，
 * 最终通过不断的分解问题，可知当绳子分割为2,6（最优解为3*3=9）两段的时候最优解为18；
 *
 * @Author shf
 * @Date 2019/11/25 21:23
 * @Version V1.0
 **/
public class Solution14_1 {
    public static int maxProductAfterCutting(int length) {
        if(length < 2) return 0;
        if(length <= 3) return length - 1;
        int[] dp = new int[length + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;//当 < 4 时不减是最优解
        int max = 0;
        for(int i=4; i<= length; i++){//从4开始计算局部最优解
            for (int j = 1; j <= i/2; j++){//问题分解
                int cur = dp[j]*dp[i-j];//每次将绳子减两段 每段从dp中找更局部的最优解
                max = max < cur ? cur : max;
            }
            dp[i] = max;//缓存最优解
        }
        return dp[length];
    }

    public static void main(String[] args) {
        int i = maxProductAfterCutting(4);
        System.out.println(i);
    }
}
