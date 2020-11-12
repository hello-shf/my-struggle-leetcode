package offer;

import common.ListNode;

/**
 * 描述：双指针
 * A:4->1->8->4->5->NULL
 * B:5->0->1->8->4->5->NULL
 *   4->1
 *         \
 *            8->4->5->NULL
 *         /
 * 5->0->1
 * 思路：双指针
 * A走到末尾也就是 5->null ：A = B；
 * B走到末尾也就是 5->null ：B = A；
 * 当走过的路程 = A+B
 * 两个指针一定会在第一个相交点相交
 * A走过的路径：4->1 |->8->4->5-> |5->0->1->NULL
 * B走过的路径：5->0->1 |->8->4->5-> |4->1->NULL
 * @Author shf
 * @Date 2020/7/5 19:23
 * @Version V1.0
 **/
public class Solution52 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode nodeA = headA, nodeB = headB;
        int n = 0;
        while (n <= 2){

            if(nodeA == null){
                nodeA = headB;
                n++;
            }
            if(nodeB == null){
                nodeB = headA;
                n++;
            }
            if(nodeA == nodeB){
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
    public static void test2(){
        int[] arr1 = {4, 1};
        ListNode node1 = new ListNode(arr1);
        int[] arr2 = {5, 0, 1};
        ListNode node2 = new ListNode(arr2);
        int[] arr3 = {8, 4, 5};
        ListNode node3 = new ListNode(arr3);
        node1.next.next = node3;
        node2.next.next.next = node3;
        System.out.println(node1);
        System.out.println(node2);
        ListNode node = getIntersectionNode(node1, node2);
        System.out.println(node);
    }

    public static void test1(){
        int[] arr1 = {0, 1};
        ListNode node1 = new ListNode(arr1);
        int[] arr2 = {4, 5};
        ListNode node2 = new ListNode(arr2);
        node1.next.next = node2;
//        int[] arr3 = {7, 8};
//        ListNode node3 = new ListNode(arr3);
//        node1.next.next = node3;
//        node2.next.next = node3;
        System.out.println(node1);
        System.out.println(node2);
        ListNode node = getIntersectionNode(node1, node2);
        System.out.println(node);
    }
}
