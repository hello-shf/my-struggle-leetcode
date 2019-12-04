package offer;

/**
 * 描述：剑指offer 21 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序。
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
 * 样例
 * 输入：[1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * 思路：
 * 1，双指针，一个从头开始l，一个从尾开始r
 * 2，当l遇到奇数跳过，当r遇到偶数跳过
 * 3，当l为偶数，r为奇数，则进行值交换
 *
 * @Author shf
 * @Date 2019/11/29 17:23
 * @Version V1.0
 **/
public class Solution21 {
    public static void reOrderArray(int [] array) {
        int l = 0, r = array.length - 1;
        while(l < r){
            while (array[l] % 2 != 0) l ++;//如果左边是奇数不处理
            while (array[r] % 2 == 0) r --;//如果右边是偶数不处理
            if(l < r){//交换
                int tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 9, 9, 5, 3, 2, 9, 6, 0, 4};
        reOrderArray(arr);
        for(int i : arr){
            System.out.print(i);
        }
    }

}
