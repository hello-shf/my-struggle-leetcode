package l374;

/**
 * 描述：374. 猜数字大小
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 * 示例 :
 *
 * 输入: n = 10, pick = 6
 * 输出: 6
 *
 *
 * @Author shf
 * @Date 2019/10/12 17:56
 * @Version V1.0
 **/
public class Solution {
    public static int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r){
            int m = (r - l) / 2 + l;
            if (guess(m) == -1){
                r = m - 1;
            }else if(guess(m) == 1){
                l = m + 1;
            }else{
                return m;
            }
        }
        return -1;
    }
    public static int guess(int n){
        int tar = 6;
        if(n < tar)
            return 1;
        if(n > tar)
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        int i = guessNumber(10);
        System.out.println(i);
    }
}
