package link;

/**
 * 描述：删除倒数第K个节点
 *
 * @Author shf
 * @Date 2019/12/24 11:24
 * @Version V1.0
 **/
public class PostK {
    public static ListNode postK(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head;
        int i = 0;
        while (i ++ < n && cur != null) {
            cur = cur.next;
        }
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        if (pre != null && pre.next != null) {
            pre.next = pre.next.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode root = new ListNode(arr);
        ListNode node = postK(root, 2);
        System.out.println(node);
    }
}
