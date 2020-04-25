package offer;

import common.ListNode;

/**
 * 描述：面试题24. 反转链表
 * 思路：https://www.cnblogs.com/hello-shf/p/11304615.html#_label3
 *
 * @Author shf
 * @Date 2020/4/25 16:06
 * @Version V1.0
 **/
public class Solution24 {
    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        return reverse(head);
    }
    public static ListNode reverse(ListNode node){
        if(node.next == null){
            return node;
        }
        ListNode cur = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return cur;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(new int[]{1, 2, 3, 4});
        System.out.println(reverseList(root));
    }
}
