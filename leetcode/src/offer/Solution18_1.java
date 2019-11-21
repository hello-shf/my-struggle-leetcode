package offer;

import common.ListNode;

/**
 * 描述：删除链表的节点
 * 给出链表头节点和待删除节点
 * 要求：时间复杂度O(1)
 * 注意：待删除节点在链表中
 *
 * @Author shf
 * @Date 2019/11/21 22:10
 * @Version V1.0
 **/
public class Solution18_1 {
    public static ListNode deleteNode(ListNode root, ListNode delNode){
        //健壮性判断
        if(root == null || delNode == null)
            return null;
        //只有一个头结点
        if (root.next == null)
            return null;
        //当删除的节点位于尾部
        if(delNode.next == null){
            ListNode cur = root;
            while (cur.next != delNode){
                cur = cur.next;
            }
            cur.next = null;
        }
        //当删除的节点位于 链表中间
        if(delNode.next != null){
            ListNode tmp = delNode.next;
            delNode.val = tmp.val;
            delNode.next = tmp.next;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] aa = {1,2,3,4};
        ListNode root = new ListNode(aa);
        ListNode cur = root;
        for(int i=0; i< 3; i++){
            cur = cur.next;
        }
        System.out.println(deleteNode(root, cur));
    }
}
