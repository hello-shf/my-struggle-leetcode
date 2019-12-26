package l237;

import common.ListNode;

/**
 * 描述：237删除链表中的节点。
 *
 * @Author shf
 * @Date 2019/12/26 9:56
 * @Version V1.0
 **/
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
