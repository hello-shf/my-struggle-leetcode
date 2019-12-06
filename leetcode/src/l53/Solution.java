package l53;

/**
 * 描述：53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 思路：
 * 1，dp记录每个子问题的解
 * 2，从头遍历，寻找以i为结尾的最大子序列和，dp记录结果
 * 3，dp[i - 1] < 0 说明前面都是负数，舍弃，并重置以i为结尾的子序列的头
 * 4，dp[i - 1] > 0 说明前面是正数，保留。
 * 5，没走过一个尾部i，取最大值
 *
 * 注意：为什么dp不用二维数组记录每个子串的最大值？因为int型天生自带比较属性。
 * @Author shf
 * @Date 2019/12/5 17:45
 * @Version V1.0
 **/
public class Solution {
    //[-2,1,-3,4,-1,2,1,-5,4],6
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i< nums.length; i++){
            if(dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] aa = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(aa));
    }
}
