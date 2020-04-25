package l376;

/**
 * 描述：
 * 思路：
 *     //[1, 17,  5, 10, 13, 15, 10,  5, 16,  8] 10
 *     //[  +   -   +  [+   +]  -  [-]  +   -] 10 -3 = 7
 *
 * @Author shf
 * @Date 2020/1/17 15:33
 * @Version V1.0
 **/
public class Solution {
    //[1, 17,  5, 10, 13, 15, 10,  5, 16,  8] 10
    //[  +   -   +  [+   +]  -  [-]  +   -] 10 -3
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return nums.length;
        int n = 1, dp = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 1; i++){
            int t = nums[i + 1] - nums[i];
            if(t == 0) continue;
            t = t > 0 ? 1 : -1;
            if(t != dp){
                n ++;
                dp = t;
            }
        }
        return n;
    }
    public static int wiggleMaxLength1(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(down, up);
    }

    public static void main(String[] args) {
        int[] dd = {1,17,5,10,13,15,10,5,16,8};
//        int[] dd = {1,7,4,9,2,5};
//        int[] dd = {3,3,3,2,5};
        System.out.println(wiggleMaxLength(dd));
    }
}
