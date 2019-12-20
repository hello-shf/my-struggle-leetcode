package l328;

import common.ListNode;

/**
 * 描述：328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 328. 奇偶链表
 * 思路：
 * 1，三个节点，odd（奇数），even(偶数)，evenHead(偶数节点的头，因为最终要 奇数尾-->偶数头)
 * 2，1->2->3->4->5->NULL odd指向1，event指向2，evenHead始终指向2
 * 3，遍历重组阶段：odd始终指向even的下一个节点，even始终指向odd的下一个节点
 * 4，重组完成后，只需要将odd即奇数尾节点的next指针指向even即偶数的头节点即可。
 *
 *
 * @Author shf
 * @Date 2019/12/20 9:58
 * @Version V1.0
 **/
public class Solution {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode root = new ListNode(arr);
        ListNode node = oddEvenList(root);
        System.out.println(node);
    }
}
