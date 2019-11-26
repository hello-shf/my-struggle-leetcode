package dp;

/**
 * 描述：剪绳子问题
 * 给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m > 1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘积是多少？
 * 例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
 *
 * @Author shf
 * @Date 2019/10/30 21:14
 * @Version V1.0
 **/
public class JSZ {
    public static int maxProductAfterCutting(int length){
        if(length < 2) return 0;
        if(length == 2) return 1;
        if(length == 3) return 2;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;//当 < 4 时不减是最优解
        int max = 0;
        for(int i=4; i <= length; i++){//从4开始计算局部最优解
            for (int j = 1; j <= i / 2; j++){//计算最优解
                int p = dp[j] * dp[i - j];//每次将绳子减两段 每段从dp中找更局部的最优解
//                System.out.println("i = " + i + ", j = " + j + ", p = " + p);
                if(max < p){
                    max = p;
                }
            }
            dp[i] = max;
        }
        return dp[length];
    }

    public static void main(String[] args) {
        int i = maxProductAfterCutting(7);
        System.out.println(i);
    }
}
