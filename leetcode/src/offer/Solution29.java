package offer;

/**
 * 描述：面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @Author shf
 * @Date 2020/5/10 19:58
 * @Version V1.0
 **/
public class Solution29 {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int io = matrix.length;
        int in = matrix[0].length;
        int[] arr = new int[in * io];
        int t = 0, b = io, l = 0, r = in;
        int k = 0;
        while (l < r && t < b){
            for(int i = l; i<r; i++){//左 -- 右
                arr[k++] =  matrix[t][i];
            }
            t ++;
            if (k == arr.length - 1) break;
            for (int i = t; i<b; i++){//上 -- 下
                arr[k++] = matrix[i][r - 1];
            }
            r --;
            if (k == arr.length) break;
            for(int i = r - 1; i>=l; i --){// 右 -- 左
                arr[k++] = matrix[b - 1][i];
            }
            b --;
            if (k == arr.length - 1) break;
            for (int i = b - 1; i>=t; i --){// 下 -- 上
                arr[k++] = matrix[i][l];
            }
            l ++;
            if (k == arr.length - 1) break;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] bb = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        int[][] aa = new int[3][3];
        aa[0][0] = 1;
        aa[0][1] = 2;
        aa[0][2] = 3;

        aa[1][0] = 4;
        aa[1][1] = 5;
        aa[1][2] = 6;

        aa[2][0] = 7;
        aa[2][1] = 8;
        aa[2][2] = 9;
        int[] ints = spiralOrder(bb);
        System.out.println();

    }
}
