package offer;

import java.util.Stack;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/5/10 22:14
 * @Version V1.0
 **/
public class Solution30 {
    class MinStack {
        Stack<Integer> s1, s2;

        /** initialize your data structure here. */
        public MinStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.add(x);
            if(s2.empty() || s2.peek() >= x){
                s2.add(x);
            }
        }

        public void pop() {
            if(s1.pop().equals(s2.peek())){
                s2.pop();
            }
        }

        public int top() {
            return s1.peek();
        }

        public int min() {
            return s2.peek();
        }
    }
}
