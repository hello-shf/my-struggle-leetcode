package l21;

import common.ListNode;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/8/14 21:06
 * @Version V1.0
 **/
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
/**
 #21. 合并两个有序链表
    思路：利用链表的天然递归性质。将两个链表头作比较，大的参与更深层次的递归
 */