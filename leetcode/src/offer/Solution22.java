package offer;

import common.ListNode;

/**
 * 描述：面试题22. 链表中倒数第k个节点
 * 思路：快慢指针
 * 方法：循环或者递归
 *
 *
 * @Author shf
 * @Date 2020/4/25 15:54
 * @Version V1.0
 **/
public class Solution22 {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slowNode = head, fastNode = head;
        int i = 0;
        while (fastNode != null){
            if(i < k){
                fastNode = fastNode.next;
            }else{
                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }
            i++;
        }
        return slowNode;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(new int[]{0, 1, 2, 3});
        System.out.println(getKthFromEnd(root, 2).val);
    }
}
