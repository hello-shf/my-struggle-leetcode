package offer;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/7/5 21:10
 * @Version V1.0
 **/
public class Solution53_2 {
    public static int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            int m = (r + l) >> 1;
            if(m < nums[m]){
                r = m - 1;
            }else if(m == nums[m]){
                l = m + 1;
            }else{
                return m;
            }
        }
        if(l != nums[l]){
            return l;
        }else if(l == r){
            return l + 1;
        }else{
            return r;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(missingNumber(arr));
    }
}
