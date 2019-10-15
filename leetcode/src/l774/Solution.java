package l774;

/**
 * 描述：744. 寻找比目标字母大的最小字母
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 *
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 *
 * 示例:
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 *
 *
 * @Author shf
 * @Date 2019/10/15 9:37
 * @Version V1.0
 **/
public class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while(l <= r){
            int m = l + (r - l)/2;
            char cur = letters[m];
            char post = m == letters.length - 1 ? letters[0] : letters[m + 1];//边界问题
            if(target >= cur && target < post){
                return post;
            }else if(target < cur){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return letters[0];//循环，当while中找不到，说明查找完整个数组都没找到，说明比数组中的每个都要大，根据题意的循环特性，即 0.
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'k';
        char c = nextGreatestLetter(letters, target);
        System.out.println(String.valueOf(c));

    }
}
