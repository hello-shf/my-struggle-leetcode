package offer;

import java.util.Stack;

/**
 * 描述：剑指offer 两个栈实现队列
 * 思路：
 * 1，栈：先进后出，队列：先进先出
 * 2，很显然如果用两个栈的话，一个栈只管进，另一个只管出
 * 3，两个栈，pushStack和popStack，当将一个栈中的数据依次出栈并压入另一个栈
 * 即可实现栈顶和栈底元素的换位。
 * 比如向pushStack依次压入1,2,3,三个元素，栈中元素位置为【3,2,1】
 * 然后pushStack依次出栈并压入popStack中，栈中元素依次为【1,2,3】
 * 这样就实现了元素栈中元素自底向顶的换位，换言之就是实现了先进先出。
 *
 * @Author shf
 * @Date 2019/11/13 15:57
 * @Version V1.0
 **/
public class Solution9{

}
class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    public void push(int x) {
        pushStack.push(x);
    }
    public int pop() {
        if(popStack.empty()){
            transfer();
        }
        return popStack.pop();
    }
    public int peek() {
        if(popStack.empty()){
            transfer();
        }
        return popStack.peek();
    }
    public boolean empty() {
        return pushStack.empty() && popStack.empty();
    }
    private void transfer(){
        while (!pushStack.empty()){
            popStack.push(pushStack.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        while (!queue.empty()){
            System.out.println(queue.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */