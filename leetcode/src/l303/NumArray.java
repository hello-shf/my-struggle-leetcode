package l303;

/**
 * 描述：区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 * 思路：
 * 因为 sumRange 方法要被经常用到，所以就联想到预加载机制，也就是先将结果计算好并缓存
 * 频繁调用 sumRange 方法的时候我们只需要将缓存的值进行简单计算即可。
 *
 *
 * @Author shf
 * @Date 2019/10/29 21:24
 * @Version V1.0
 **/
public class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i=0; i< nums.length; i++){
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(arr);
        NumArray numArray1 = new NumArray(arr);
        numArray.equals(numArray1);
        int i = numArray.sumRange(0, 2);
        System.out.println(i);
    }
}
