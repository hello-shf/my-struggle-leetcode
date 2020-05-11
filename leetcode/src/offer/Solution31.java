package offer;

import java.util.Stack;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/5/10 22:31
 * @Version V1.0
 **/
public class Solution31 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5}, popped = {4,5,3,2,1};
        boolean b = validateStackSequences(pushed, popped);
        System.out.println(b);

    }
}
