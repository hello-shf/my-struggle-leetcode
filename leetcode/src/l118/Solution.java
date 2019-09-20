package l118;


import java.util.ArrayList;
import java.util.List;

/**
 * 描述：118. 杨辉三角
 *
 * #118. 杨辉三角
 * 思路：
 * 1，递归思想，类似斐波那锲递归，计算兔子数量的算法
 * 2，递归到numRows == 1，此时可以得到杨辉三角的第一层，然后返回给上层递归。然后进行计算。
 * @Author shf
 * @Date 2019/9/20 9:31
 * @Version V1.0
 **/
public class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        if(numRows == 0)
            return rows;
        generate(numRows, rows);
        return rows;
    }

    public static List<Integer> generate(int numRows, List<List<Integer>> rows) {
        List<Integer> row = new ArrayList<>();
        if (numRows == 1) {
            row.add(1);
            rows.add(row);
            return row;
        }
        List<Integer> preRow = generate(numRows - 1, rows);
        row.add(1);
        for (int i=1; i<preRow.size(); i++){
            row.add(preRow.get(i - 1) + preRow.get(i));
        }
        row.add(1);
        rows.add(row);
        return row;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(4);
        System.out.println(generate);
    }
}
