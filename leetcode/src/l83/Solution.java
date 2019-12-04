package l83;

import common.ListNode;


/**
 * 描述：83. 删除排序链表中的重复元素
 * 思路：
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 *
 * @Author shf
 * @Date 2019/10/22 21:06
 * @Version V1.0
 **/
public class Solution {
//    public static ListNode deleteDuplicates(ListNode head) {
//        if(head == null){
//            return null;
//        }
//        if(head.next == null){
//            return head;
//        }
//        if(head.val == head.next.val){
//            head.next = deleteDuplicates(head.next.next);
//        }else{
//            head.next = deleteDuplicates(head.next);
//        }
//        return head;
//    }
//    public static ListNode deleteDuplicates(ListNode head) {
//        if(head == null){
//            return head;
//        }
//        head.next = delete(head, head.next);
//        return head;
//    }
//    public static ListNode delete(ListNode prev, ListNode cur){
//        if(cur == null){
//            return null;
//        }
//        if(prev.val == cur.val){
//            cur = delete(prev, cur.next);
//        }else{
//            cur = delete(prev.next, cur.next);
//        }
//        return prev;
//    }
    public static ListNode deleteDuplicates1(ListNode head){
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
    public static ListNode deleteDuplicates(ListNode head){
        ListNode newHead = head;
        ListNode cur = newHead;
        while (head != null){
            if(head.next == null){
                cur.next = null;
                break;
            }
            if (cur.val == head.next.val) {
                head = head.next;
                continue;
            }else{
                cur.next = head.next;
                head = head.next;
                cur = cur.next;
            }
        }
        return newHead;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 3};//, 2, 3, 3, 3, 4, 4};
        ListNode listNode = new ListNode(arr);
        ListNode node = deleteDuplicates(listNode);
        System.out.println(node);

        for(int i = 2; i<= 57; i++){
            System.out.println(i);
        }
    }
}
