package l876;

import common.ListNode;

/**
 * 描述：
 * 思路：
 * 1，快慢指针
 *
 * @Author shf
 * @Date 2019/12/19 17:39
 * @Version V1.0
 **/
public class Solution {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        ListNode root = new ListNode(arr);
        ListNode node = middleNode(root);
        System.out.println(node);
    }
}
