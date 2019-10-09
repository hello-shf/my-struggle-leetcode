package l349;

import java.util.HashSet;
/**
 * 描述：349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 思路：
 * 1，利用set先在各自数组中去重
 * 2，利用hashset的retainAll方法来求交集
 * 一般时间复杂度在O(m + n)，最坏为O(m * n)
 *
 *
 * @Author shf
 * @Date 2019/9/29 9:39
 * @Version V1.0
 **/
public class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (Integer n : nums1)
            set1.add(n);
        for (Integer n : nums2)
            set2.add(n);
        set1.retainAll(set2);

        int[] result = new int[set1.size()];
        int index = 0;
        for (Integer n : set1)
            result[index ++] = n;
        return result;
    }

    public static void main(String[] args) {
        int[] aa = {4, 9, 5}, bb = {9, 4, 9, 8, 4};
        int[] ints = intersection(aa, bb);
        for (int i : ints)
            System.out.println(i);

    }
}
