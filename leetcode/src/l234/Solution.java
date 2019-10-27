package l234;

import common.ListNode;

import java.util.Stack;

/**
 * 描述：234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 *
 * @Author shf
 * @Date 2019/10/27 14:52
 * @Version V1.0
 **/
public class Solution {
    public static boolean isPalindrome1(ListNode head) {
        if(head == null){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null || fast != null){
            if(fast != null){
                if(fast.next == null){
                    fast = null;
                }else{
                    fast = fast.next.next;
                }
            }else if(slow != null){
                stack.push(slow.val);
            }
            slow = slow.next;
        }
        while (stack.size() != 0){
            Integer e = stack.pop();
            if(e != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null || fast != null){
            if(fast != null){
                if(fast.next == null){
                    fast = null;
                }else{
                    fast = fast.next.next;
                }
            }else if(slow != null){
                stack.push(slow.val);
            }
            slow = slow.next;
        }
        while (stack.size() != 0){
            Integer e = stack.pop();
            if(e != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        ListNode node = new ListNode(arr);
        boolean palindrome = isPalindrome(node);
        System.out.println(palindrome);
    }
}
