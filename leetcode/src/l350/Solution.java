package l350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：350. 两个数组的交集 II
 *给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 *
 *
 *
 * #350. 两个数组的交集 II
 * 思路：
 * 1，使用hashMap首先记录单个数据中的重复项，即使用hashmap将数组映射为<元素，频率>的映射关系。
 * 2，循环第二个数组，如果在hashmap中存在，则将 频率-1，另外使用list记录两个数组的交集。
 *
 * @Author shf
 * @Date 2019/10/10 21:22
 * @Version V1.0
 **/
public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums1){
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        }
        for (int key : nums2){
            if(map.containsKey(key)){
                map.put(key, map.get(key) - 1);
                if(map.get(key) == 0){
                    map.remove(key);
                }
                result.add(key);
            }
        }
        int[] res = new int[result.size()];
        for(int i = 0; i< result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] ints = intersect(nums1, nums2);
        for (int i : ints)
            System.out.print(i);
        System.out.println("");
    }
}
