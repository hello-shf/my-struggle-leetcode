package l19;

import common.ListNode;

/**
 * 描述：19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * @Author shf
 * @Date 2020/11/11 10:36
 * @Version V1.0
 **/
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 0) return head;
        ListNode fast = head, slow = head;
        for(int i = 0; i<n; i++){
            fast = fast.next;
        }
        //头边界
        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
