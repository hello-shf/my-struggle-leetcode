package offer;

import common.ListNode;

/**
 * 描述：删除链表中的重复元素
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留。
 * 样例1
 * 输入：1->2->3->3->4->4->5
 * 输出：1->2->5
 * 样例2
 * 输入：1->1->1->2->3
 * 输出：2->3
 * 思路：
 * 1，构建一个假头，解决链表从头就开始重复的情况
 * 2，维护两个指针，一个当前节点cur和一个当前节点的前一个节点prev
 * 3，遍历链表，如果prev.next.val == cur.val 说明存在重复元素，cur向前走
 * 4，当 prev.next.next == cur 说明3步骤中cur只走了一步，没有重复元素，cur和prev都同步向前
 * 5，当prev.next.next != cur 说明3步骤cur向前走了多于1步，存在重复元素，则prev.next = cur;修改prev的指针即删除重复节点
 *
 * @Author shf
 * @Date 2019/11/28 17:34
 * @Version V1.0
 **/
public class Solution18_2 {
    public static ListNode deleteDuplication(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(head.val - 1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = prev.next;
        while (cur != null){
            while (cur != null && prev.next.val == cur.val){
                cur = cur.next;
            }
            if(prev.next.next == cur){
                prev = prev.next;
            }else{
                prev.next = cur;
            }
            cur = prev.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] aa = {1, 2, 2, 2, 3, 4, 5};
        ListNode root = new ListNode(aa);
        ListNode node = deleteDuplication(root);
        System.out.println(node);
    }
}
/**
 while (prev.next!=null) {
 while (cur != null && prev.next.val == cur.val) {
 cur = cur.next;
 }
 if ( prev.next.next == cur){
 prev = prev.next;
 }else {
 prev.next = cur;
 }
 cur = prev.next;
 }
 */

/**
 while (cur != null && cur.next != null){
     if(cur.val == cur.next.val){
         while (cur.next != null && cur.val == cur.next.val) {
            cur = cur.next;
         }
         cur = cur.next;
         if(cur == null || (cur.next != null && cur.val != cur.next.val)){
            prev.next = cur;
         }
     }else{
         cur = cur.next;
         prev = prev.next;
     }
 }

 */