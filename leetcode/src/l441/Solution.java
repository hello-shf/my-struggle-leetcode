package l441;

/**
 * 描述：441. 排列硬币
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 *
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 *
 * n = 5
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 *
 * n = 8
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * 因为第四行不完整，所以返回3.
 *
 *
 *
 * 坑：double， 临界值不再是单纯的==，而是要判断当前和下一个
 *
 * @Author shf
 * @Date 2019/10/14 10:01
 * @Version V1.0
 **/
public class Solution {
    public static int arrangeCoins(int n) {
        int l = 0, r = n;
        while(l <= r){
            int m = (r - l)/2 + l;
            double t = (double)m*(m + 1)/2;// m
            double t2 = ((double)m*m + 3*m + 2)/2; // m + 1
            if(t <= n && t2 > n){// 注意临界值
                return m;
            }else if( t < n){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return l - 1;
    }

    public static void main(String[] args) {
        int i = arrangeCoins(8);
        System.out.println(i);
    }
}
