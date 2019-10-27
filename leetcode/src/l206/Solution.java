package l206;

import common.ListNode;

/**
 * 描述：206 链表反转
 *
 * @Author shf
 * @Date 2019/10/27 11:09
 * @Version V1.0
 **/
public class Solution {
    public static ListNode reverseList(ListNode head) {
        if(head.next == null || head == null){
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode root = new ListNode(arr);
        ListNode node = reverseList(root);
        System.out.println(node);
    }
}
