package offer;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/7/5 20:39
 * @Version V1.0
 **/
public class Solution53 {
    public static int search(int[] nums, int target) {
        int l =0, r = nums.length - 1;
        while (l < r){
            if(target < nums[r]){
                r -= 1;
            }else if(target > nums[l]){
                l += 1;
            }else {
                return r - l + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 6, 6, 7};
        int search = search(arr, 6);
        System.out.println(search);
    }
}
