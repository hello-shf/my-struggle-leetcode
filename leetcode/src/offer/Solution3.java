package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：offer-题号：3，找出数组中的重复元素
 * 给定一个长度为 n 的整数数组 nums，数组中所有的数字都在 0∼n−1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 样例：
 * 给定 nums = [2, 3, 5, 4, 3, 2, 6, 7]。
 * 返回 2 或 3
 *
 * @Author shf
 * @Date 2019/11/4 21:27
 * @Version V1.0
 **/
public class Solution3 {
    public static int duplicateInArray(int[] nums){
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(Integer num : nums){
            if(map.containsKey(num)){
                return num;
            }else{
                map.put(num, 0);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        int i = duplicateInArray(nums);
        System.out.println(i);
    }
}
