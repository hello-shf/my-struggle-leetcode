package test;

/**
 * 描述：
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * @Author shf
 * @Date 2020/11/6 19:16
 * @Version V1.0
 **/
public class Solution35_test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        int i = search(arr, 7);
        System.out.println(i);
    }
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //输入: [1,3,5,6], 5
    //输出: 2
    public static int search(int[] nums, int target){
        if(nums.length == 0) return 0;
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(nums[m] < target) {
                //[l, m+1]so
                l = m + 1;
            } else if(nums[m] > target) {
                //[m - 1, r]
                r = m - 1;
            } else {
                return m;
            }
        }
        return l;
    }
}
