package offer;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/6/16 10:31
 * @Version V1.0
 **/
public class Solution45 {
    /**
     * 快排实现
     * @param nums
     * @return
     */
    public static String minNumber1(int[] nums) {
        fast(nums, 0, nums.length - 1);
        StringBuilder builder = new StringBuilder();
        for(int num : nums){
            builder.append(num);
        }
        return builder.toString();
    }
    public static void fast(int[] arr, int l, int r){
        if(l < r){
            int middle = getMiddle(arr, l, r);
            fast(arr, l, middle - 1);
            fast(arr, middle + 1, r);
        }
    }
    public static int getMiddle(int[] arr, int l, int r){
        int middle = arr[l];
        while (l < r){
            while (l < r && compare(arr[r], middle))
                r--;
            arr[l] = arr[r];
            while (l < r && compare(middle, arr[l]))
                l++;
            arr[r] = arr[l];
        }
        arr[l] = middle;
        return l;
    }

    public static String minNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length - 1 - i; j++){
                if(compare(nums[j], nums[j + 1])){
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int num : nums){
            builder.append(num);
        }
        return builder.toString();
    }
    public static boolean compare(int num1, int num2){
        Double t1 = Double.valueOf(String.valueOf(num1) + String.valueOf(num2));
        Double t2 = Double.valueOf(String.valueOf(num2) + String.valueOf(num1));
        return t1 > t2;
    }

    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        System.out.println(minNumber1(arr));
    }
}

/**
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    示例 1:

    输入: [10,2]
    输出: "102"
    示例 2:

    输入: [3,30,34,5,9]
    输出: "3033459"
     
    [1399,1365]
    提示:

    0 < nums.length <= 100

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/