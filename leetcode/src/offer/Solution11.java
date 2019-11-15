package offer;

/**
 * 描述：剑指offer 11题
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个升序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 数组可能包含重复项。
 * 注意：数组内所含元素非负，若数组大小为0，请返回-1。
 * 样例
 * 输入：nums=[2,2,2,0,1]
 * 输出：0
 *
 * 思路：二分查找
 *
 *
 * @Author shf
 * @Date 2019/11/15 10:32
 * @Version V1.0
 **/
public class Solution11 {
    public static int findMin(int[] nums) {
        if(nums.length == 0)
            return -1;
        int l = 0, r = nums.length-1;
        while (nums[l] == nums[r]) l ++;//处理特殊情况，【1,1,1,0,1】
        while (l != r){
            int m = (r - l)/2 + l;
            if(nums[m] <= nums[r]){//当中间元素< 右边界，即最小元素在l-m之间
                r = m;
            }else if(nums[m] >= nums[l]){//当中间元素 > 左边界，即最小元素在m - r之间
                l = m + 1;
            }
        }
        return nums[l];
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,1};
        int min = findMin(arr);
        System.out.println(min);
    }
}
/**
 if(nums.length == 0)
 return -1;
 int l = 0, r = nums.length-1;
 while (nums[l] == nums[r]) l ++;
 while (l != r){
 if(nums[l] == nums[l + 1]){
 l ++;
 }else if(nums[r] == nums[r - 1]){
 r --;
 }else{
 int m = (r - l)/2 + l;
 if(nums[m] <= nums[r]){
 r = m;
 }else if(nums[m] >= nums[l]){
 l = m + 1;
 }
 }
 }
 return nums[l];
 */