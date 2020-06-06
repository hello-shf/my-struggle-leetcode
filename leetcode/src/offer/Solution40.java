package offer;

import java.util.PriorityQueue;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/6/6 23:11
 * @Version V1.0
 **/
public class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : arr){
            queue.add(i);
        }
        int[] res = new int[k];
        for(int i = 0 ; i<k; i++){
            res[i] = queue.poll();
        }
        return res;
    }
}
