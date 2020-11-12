package offer;

/**
 * 描述：面试题42. 连续子数组的最大和
 *
 *
 * @Author shf
 * @Date 2020/6/13 22:49
 * @Version V1.0
 **/
public class Solution42 {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i = 1; i<nums.length; i++){
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
