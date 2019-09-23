package l119;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：#119 杨辉三角形2
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 *
 * @Author shf
 * @Date 2019/9/23 9:47
 * @Version V1.0
 **/
public class Solution {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex == 0){
            return list;
        }
        list.add(1);
        if(rowIndex == 1){
            return list;
        }
        for(int i = 1 ; i< rowIndex ; i++){
            list.add(1);
            for(int j = 0; j < i; j++){
                list.add(list.get(0) + list.get(1));
                list.remove(0);
            }
            list.add(1);
            list.remove(0);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(4);
        for (int cell : row)
            System.out.print(cell);
        System.out.println(" ");
    }
}
