package offer;

/**
 * 描述：12 offer 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 注意：
 * 输入的路径不为空；
 * 所有出现的字符均为大写英文字母；
 * 样例
 * matrix={
 * {'a', 'b', 't', 'g'},
 * {'c', 'f', 'c', 's'},
 * {'j', 'd', 'e', 'h'}
 * }
 * str="bfce" , return "true"
 * str="bfdd" , return "false"
 *
 * 思路：回溯法
 * 1，从二维数组中逐个遍历
 * 2，每遍历一个元素，当发现该字符 在 目标字符串中的 i索引处 则递归的找其 左右上下 的元素是不是字符串 i + 1 处的字符
 * 3，按照 2 步骤逐个递归每个已存在字符串中的字符的 左右上下 索引位置的元素，当发现在四个位置都没有找到，则回溯到字符串的 i - 1 位置重新查找
 *
 * @Author shf
 * @Date 2019/11/19 21:50
 * @Version V1.0
 **/
public class Solution12 {
    public static boolean hasPath(char[][] matrix, String str) {
        if(matrix == null || matrix.length == 0 || str == null)
            return false;
        int rows = matrix.length;//记录数组的行
        int cols = matrix[0].length;//记录数组的列

        int pathLength = 0;//从字符串的第一个元素开始查找
        boolean[][] visited = new boolean[rows][cols];//记录访问过的每个位置，false：访问过，true：未访问存在
                                                        //主要是题意规定路径中每个元素只能走一次
        for (int i=0; i< rows; i++){
            for (int j = 0; j < cols; j++){//逐个遍历数组中的元素
                if(hasPathCode(matrix, rows, cols, i, j, str, pathLength, visited))
                    return true;
            }
        }
        return false;
    }
    public static boolean hasPathCode(char[][] matrix, int rows, int cols, int row, int col, String str, int pathLength, boolean[][] visited){

        boolean flag = false;
        if(row >= 0 && row < rows &&
                col >= 0 && col < cols &&//防止数组越界
                !visited[row][col] &&//未访问过
                matrix[row][col] == str.charAt(pathLength)){//判断该位置的字符是否等于字符串中的目标字符
            pathLength ++;
            if(pathLength == str.length())
                return true;
            visited[row][col] = true;//记录该位置已是路径中的字符
            flag = hasPathCode(matrix, rows, cols, row + 1, col, str, pathLength, visited) ||
                    hasPathCode(matrix, rows, cols, row - 1, col, str, pathLength, visited) ||
                    hasPathCode(matrix, rows, cols, row, col + 1, str, pathLength, visited) ||
                    hasPathCode(matrix, rows, cols, row, col - 1, str, pathLength, visited);
            if(!flag){
                pathLength --;//回溯
                visited[row][col] = false;//未走过的位置重新置为false（java中的值传递，引用类型）
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}
        };
        boolean flag = hasPath(chars, "bfce");
        System.out.println(flag);
        flag = hasPath(chars, "bfdd");
        System.out.println(flag);
    }
}
