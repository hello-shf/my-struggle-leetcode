package offer;

/**
 * 描述：斐波那锲数列
 *
 * @Author shf
 * @Date 2019/11/8 23:28
 * @Version V1.0
 **/
public class Solution10 {
    /*递归解法*/
    public static long fibonacci(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    /*动态规划*/
    public static long fibonacciFor(int n){
        int[] dp = new int[n + 1];
        for(int i=0; i<= n; i++){
            if(i <= 1)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[dp.length-1];
    }
    /*动态规划*/
    public static long jump(int n){
        int[] dp = new int[n + 1];
        for(int i=0; i<= n; i++){
            if(i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[dp.length - 1];
    }


    public static void main(String[] args) {
        long time1 = System.nanoTime();
        long fibonacci = fibonacci(6);
        long time2 = System.nanoTime();
        System.out.println(fibonacci);
        long time3 = System.nanoTime();
        long fibonacciFor = fibonacciFor(6);
        long time4 = System.nanoTime();
        System.out.println(fibonacciFor);
        System.out.println(time2-time1);
        System.out.println(time4-time3);
        long jump = jump(10);
        System.out.println(jump);
    }
}
