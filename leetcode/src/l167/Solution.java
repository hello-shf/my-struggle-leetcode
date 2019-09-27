package l167;

/**
 * 描述：167. 两数之和 II - 输入有序数组
 *
 * 思路：#167. 两数之和 II - 输入有序数组
 * 1，双指针，l取数组头，r取数组尾
 * 2，在有序数组中，当 arr[l] + arr[r] < target 即min+ max < target，所以左指针右移，反之右指针左移。
 *
 * @Author shf
 * @Date 2019/9/27 17:32
 * @Version V1.0
 **/
public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r){
            int sum = numbers[l] + numbers[r];
            if(sum < target){
                l ++;
            }if(sum > target){
                r --;
            }if(sum == target){
                return new int[]{l + 1, r + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        int[] numbers = {2, 7, 11, 15, 18, 40, 50};
        int[] numbers = {-1, 0};
        int target = -1;
        int[] ints = twoSum(numbers, target);
        for (int i : ints){
            System.out.println(i);
        }

    }
}
