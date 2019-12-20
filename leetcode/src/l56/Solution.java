package l56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述：56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 思路：
 * 【start, end】
 * 1，先根据区间开始位置start排序
 * 2，遍历，拿后一个区间的end和前一个区间的start比较
 * 3，如果ints[i+1].end <= int[i].start类似：【1，6】【3,5】，即可合并两个区间
 * 4，需要合并的两个区间需要比较end，取较大那个。start直接取前一个区间的值即可，因为已经排过序了。
 * 5，并将区间合并到 i + 1索引位置，因为还要和下一个位置的区间继续比较比如：【1,6】【2,5】【5,8】
 * 6，如果不需要合并即可将该区间放到list结果集中。
 *
 * @Author shf
 * @Date 2019/12/18 9:55
 * @Version V1.0
 **/
public class Solution {
    public static int[][] merge(int[][] intervals) {
        if(intervals == null) return null;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int i=0; i<intervals.length; i++){
            if(i == intervals.length - 1){
                list.add(intervals[i]);
                break;
            }
            if(intervals[i + 1][0] <= intervals[i][1]){
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = intervals[i][1] > intervals[i + 1][1] ? intervals[i][1] : intervals[i+1][1];
            }else{
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{8,10},{1,3},{2,6},{15,18}};
        int[][] merge = merge(arr);
        System.out.println();
    }
}
