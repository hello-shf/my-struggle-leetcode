package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：面试题39. 数组中出现次数超过一半的数字
 * 思路：HashMap
 *
 * @Author shf
 * @Date 2020/6/6 22:47
 * @Version V1.0
 **/
public class Solution39 {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length/2);
        int helf = nums.length / 2;
        for(Integer i : nums){
            Integer n = map.get(i);
            if(n == null) n = 0;
            map.put(i, ++n);
            if(n > helf){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(arr));
    }
}
