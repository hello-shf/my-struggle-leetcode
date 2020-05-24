package offer;

import java.util.Stack;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/5/23 20:18
 * @Version V1.0
 **/
public class Solution33 {
    public static boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i>= 0; i--){
            if(postorder[i] > root) return false;
            while (!stack.isEmpty() && postorder[i] < stack.peek())
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,6,5};
        boolean b = verifyPostorder(arr);
        System.out.println(b);
    }
}
