package offer;

/**
 * 描述：剑指offer - 13：机器人的运动范围
 * 地上有一个 m 行和 n 列的方格，横纵坐标范围分别是 0∼m−1 和 0∼n−1。
 *
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格。
 *
 * 但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 *
 * 请问该机器人能够达到多少个格子？
 *
 * 样例1
 * 输入：k=7, m=4, n=5
 *
 * 输出：20
 * 样例2
 * 输入：k=18, m=40, n=40
 *
 * 输出：1484
 *
 * 解释：当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *       但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 *
 * 思路：
 * 1，从初始位置 【0，0】开始
 * 2，递归上下左右四个位置，走过的地方 通过 visited矩阵 设置为true
 * 3，合格的位置 total ++
 *
 * @Author shf
 * @Date 2019/11/20 22:03
 * @Version V1.0
 **/
public class Solution13 {
    int total = 0;
    public int movingCount(int threshold, int rows, int cols) {
        if(rows == 0 || cols == 0)
            return 0;
        boolean[][] visited = new boolean[rows][cols];
        check(threshold, rows, cols, 0, 0, visited);
        return total;
    }
    public void check(int k, int rows, int cols, int row, int col, boolean[][] visited){
        if(row >= 0 && row < rows &&
            col >= 0 && col < cols &&
            sum(row) + sum(col) <= k &&
            !visited[row][col]){
            visited[row][col] = true;
            total ++;
            check(k, rows, cols, row + 1, col, visited);
            check(k, rows, cols, row - 1, col, visited);
            check(k, rows, cols, row, col + 1, visited);
            check(k, rows, cols, row, col - 1, visited);
        }
    }
    public int sum(int i){
        int sum = 0;
        while(i != 0){
            sum += i%10;
            i = i / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int i = solution13.movingCount(0, 4, 5);
        System.out.println(i);
    }
}
