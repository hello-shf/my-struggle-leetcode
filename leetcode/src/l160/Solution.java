package l160;

import common.ListNode;

/**
 * 描述：160 相交链表
 *
 * @Author shf
 * @Date 2019/10/24 21:40
 * @Version V1.0
 **/
public class Solution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Integer num = 0;
        ListNode l = headA;//找到较长
        ListNode s = headB;//较短的
        ListNode a = headA;
        ListNode b = headB;
        while (a != null || b != null){
            if(a != null){
                a = a.next;
            }
            if(b != null){
                b = b.next;
            }
            if (a == null && b != null) {
                l = headB;
                s = headA;
                num ++;//找到长度差
            }
            if(a != null && b == null){
                l = headA;
                s = headB;
                num ++;
            }
        }
        while(l != null && s != null){
            while (num != 0){//较长的消除长度差
                l = l.next;
                num --;
            }
            if(s == l){
                return l;
            }else{
                l = l.next;
                s = s.next;
            }
        }
        return null;
    }
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) return null;
//        ListNode pA = headA, pB = headB;
//        while (pA != pB) {
//            pA = pA == null ? headB : pA.next;
//            pB = pB == null ? headA : pB.next;
//        }
//        return pA;
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 7, 8};
        int[] b = {3, 4};
        int[] c = {5, 6};
        ListNode nodeA = new ListNode(a);
        ListNode nodeB = new ListNode(b);
        ListNode nodeC = new ListNode(c);
        nodeA.next.next.next.next = nodeC;
        nodeB.next.next = nodeC;
        ListNode node = getIntersectionNode1(nodeA, nodeB);
        System.out.println(node);
//        ListNode nodeA = new ListNode(1);
//        ListNode nodeB = nodeA;
//        ListNode node = getIntersectionNode(nodeA, nodeB);
//        System.out.println(node);
    }
}
