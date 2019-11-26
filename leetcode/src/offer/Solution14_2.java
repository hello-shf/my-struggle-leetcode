package offer;

/**
 * 描述：剪绳子 - 贪心算法
 * 给你一根长度为 n 绳子，请把绳子剪成 m 段（m、n 都是整数，2≤n≤58 并且 m≥2）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]k[1] … k[m] 可能的最大乘积是多少？
 * 例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
 *
 * 样例
 * 输入：8
 * 输出：18
 * 解题思路：
 * 1，通过分析找出解决问题的方法。
 * 2，证明这种方法是成立的。
 *
 * 思路：
 * 1，通过分析当绳子>=5的时候总存在 3(3-n) > 2(2-n) > n
 * 2，将绳子尽可能多的分割为3长度
 * 3，最后一段如果为1，则将前一段3和最后一段合并为4（很显然4 > 1*3）
 *
 * @Author shf
 * @Date 2019/11/26 9:59
 * @Version V1.0
 **/
public class Solution14_2 {
    public static int maxProductAfterCutting(int length) {
        if(length < 2) return 0;
        if(length <= 3) return length - 1;
        int l3 = length / 3;
        //当最后一段为1，显然这不是最优解，
        // 需要将前一段长度为3的绳子和最后一段1合并为一个长度4.
        if(length - l3 * 3 == 1)
            l3 -= 1;
        int l2 = (length - l3 * 3) / 2;
        return (int) Math.pow(3, l3) * (int) Math.pow(2, l2);
    }

    public static void main(String[] args) {
        int i = maxProductAfterCutting(8);
        System.out.println(i);
    }
}
