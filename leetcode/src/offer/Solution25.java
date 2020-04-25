package offer;

import common.ListNode;

/**
 * 描述：面试题25. 合并两个排序的链表
 * 思路：构造假头
 *
 * @Author shf
 * @Date 2020/4/25 16:36
 * @Version V1.0
 **/
public class Solution25 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(1);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null ? l2 : l1);
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{1, 3, 5});
        ListNode l2 = new ListNode(new int[]{2, 3, 5});
        System.out.println(mergeTwoLists(l1, l2));
    }
}
