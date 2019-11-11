package offer.array;

/**
 * 描述：斐波那锲数列
 *
 * @Author shf
 * @Date 2019/11/8 23:28
 * @Version V1.0
 **/
public class Solution10 {
    public static long fibonacci(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
}
