package offer;

/**
 * 描述：剑指offer-16 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的 exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * 样例1
 * 输入：10 ，2
 * 输出：100
 * 思路：
 * 1，2^7 = 2 * 2^2 * 2^4
 * 2，使用位运算每次将指数右移一位，即指数*2
 * 3，最后判断指数是正数还是负数，负数取倒数
 * @Author shf
 * @Date 2019/11/27 14:34
 * @Version V1.0
 **/
public class Solution16 {
    public static double Power(double base, int exponent) {
        double res = 1;
        int e = Math.abs(exponent);
        while (e != 0){
            if((e&1) != 0)//二进制不为0继续
                res *= base;
            base *= base;
            e = e >> 1;//位运算代替 除2 操作
        }
        if(exponent < 0)
            return 1/res;
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Power(2, -7));
        System.out.println(Math.pow(2, -7));
        System.out.println(7 >> 1);
        System.out.println(16*16);
        System.out.println(Math.pow(2, 0));
    }
}
