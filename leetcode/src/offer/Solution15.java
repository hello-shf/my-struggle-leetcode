package offer;

/**
 * 描述：二进制中1的个数
 * 输入一个32位整数，输出该数二进制表示中1的个数。
 * 注意：
 * 负数在计算机中用其绝对值的补码来表示。
 * 样例1
 * 输入：9
 * 输出：2
 * 解释：9的二进制表示是1001，一共有2个1。
 *
 * 样例2
 * 输入：-2
 * 输出：31
 * 解释：-2在计算机里会被表示成11111111111111111111111111111110，
 *       一共有31个1。
 * 思路：位运算
 * 假如 n=9 二进制表示为 1001（二进制中有两个1）
 * (n-1)&n 即 (1000) & (1001) = 1000 = 8；
 * 继续(n-1)&n 即 (0111) & (1000) = 0000 = 0;
 * 从9到0经过了两次(n-1)&n
 *
 * @Author shf
 * @Date 2019/11/26 10:53
 * @Version V1.0
 **/
public class Solution15 {
    //普通解法
    public static int NumberOf1(int n) {
        if(n == 0) return 0;
        int count = 1, l = 1;
        int m = Math.abs(n);
        while(m / 2 != 0){
            if(m % 2 == 1){
                count ++;
            }
            m = m / 2;
            l ++;
        }
        if(n < 0){
            count = 32 - l + count;
        }
        return count;
    }
    //位运算
    public static int NumberOf1_2(int n) {
        int count = 0;
        while (n != 0){
            count ++;
            n = (n - 1) & n;//比如 9 (1000) & 1001 = 1000；
        }
        return count;
    }
    //举一反三
    public static boolean square(int n){
        if(NumberOf1_2(n) == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(square(9));
        System.out.println(NumberOf1(4));
        System.out.println(NumberOf1_2(4));
    }


}
