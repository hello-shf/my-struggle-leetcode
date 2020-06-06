package offer;

import com.sun.org.apache.xerces.internal.impl.xs.XSModelImpl;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 描述：面试题41. 数据流中的中位数
 *
 * @Author shf
 * @Date 2020/6/6 23:27
 * @Version V1.0
 **/
public class Solution41 {
    Queue<Integer> A, B;
    public Solution41() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((x, y) ->(y - x));
    }

    public void addNum(int num) {
        if(A.size() != B.size()){
            A.add(num);
            B.add(A.poll());
        }else{
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
