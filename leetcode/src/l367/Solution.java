package l367;

/**
 * 描述：367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 * 367. 有效的完全平方数
 * 思路：
 * 1，二分法，左右界限定为 0 - num。
 * 采坑：m的平方，我怕m太大平方超过Integer.MAX_VALUE
 * 所以我写的：double s = m * m;但是这样是错误的，应该写成(double)m * m;
 * 前者的写法是将m * m的结果强转为 double，这种写法是错误的
 * 因为当 m * m > Integer.MAX_VALUE已经产生了错误，这时候再进行强转已经错误了
 * @Author shf
 * @Date 2019/10/11 21:02
 * @Version V1.0
 **/
public class Solution {
    public static boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l <= r){
            int m = (r - l)/2 + l;
            if((double)m * m < num){
                l = m + 1;
            }else if((double)m * m > num){
                r = m - 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = isPerfectSquare(808201);
        System.out.println(b);
    }
}
