package offer;

/**
 * 描述： 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 1  3  5  7  11
 * 2  4  6  9  13
 * 3  6  8  10 15
 * 5  8  10 11 19
 * 思路：比如查找8元素
 * 1，遍历第一行，发现11 > 8所以后续遍历直接可以跳过11所在的列。
 * 2，在后续遍历每一行的时候，我们都照1中这样踢除我们不需要的范围，有效的缩小索引范围
 * @Author shf
 * @Date 2019/11/4 21:52
 * @Version V1.0
 **/

public class Solution4 {
    public static boolean searchArray(int[][] array, int target) {
        if(array.length == 0) return false;
        int l = array[0].length;
        for(int i =0 ; i< array.length; i++){
            for(int j = 0; j < l; j++){
                if(array[i][j] > target){
                    l = j;
                }else if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[0][0] = 0;
        arr[0][1] = 1;
        arr[0][2] = 9;
        arr[1][0] = 3;
        arr[1][1] = 4;
        arr[1][2] = 10;
        arr[2][0] = 6;
        arr[2][1] = 7;
        arr[2][2] = 11;
        for (int i = 0; i < arr.length; i++){
            int[] inner = arr[i];
            for(int j : inner){
                System.out.print(j);
            }
            System.out.println();
        }
        boolean b = searchArray(arr, 3);
        System.out.println(b);

    }
}
