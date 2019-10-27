package l203;

import common.ListNode;

/**
 * 描述：203. 移除链表元素
 * 思路：
 * 构造一个虚拟头结点，即常用的dummyHead，然后循环该链表
 * 链表删除一定是找到前一个节点，删除的正确姿势：找到 == 关系就 prev = prev.next.next;
 *
 * @Author shf
 * @Date 2019/10/27 10:02
 * @Version V1.0
 **/
public class Solution {
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;//给head造个虚拟头结点
        while (prev != null && prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }else{//这里一定是else，因为防止1， 1。。。 这样连续的重复节点
                prev = prev.next;
            }
        }
        return dummyHead.next;//返回虚拟头结点的下一个节点
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 4};//{1, 1, 1};//, 2};//, 3, 4, 5};
        ListNode root = new ListNode(arr);
        ListNode node = removeElements(root, 4);
        System.out.println(node);

    }
}
