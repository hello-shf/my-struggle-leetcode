package l141;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * @Author shf
 * @Date 2019/10/23 20:58
 * @Version V1.0
 **/
public class Solution {
    //递归： 空间复杂度：o(n)
    public static boolean hasCycle(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        return hasCycle(head, map);
    }
    public static boolean hasCycle(ListNode head, Map<Integer, Integer> map) {
        if(head == null){
            return false;
        }
        if(map.containsKey(head.hashCode())){
            return true;
        }
        map.put(head.hashCode(), 0);
        return hasCycle(head.next, map);
    }
    //循环 空间复杂度：o(n)
    public static boolean hasCycle1(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        while (head != null){
            if(map.containsKey(head.hashCode())){
                return true;
            }
            map.put(head.hashCode(), 0);
            head = head.next;
        }
        return false;
    }
    //双指针
    public static boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;//慢指针一次走一格
            fast = fast.next.next;//快指针一次走两格
        }
        return true;//走到这一步说明slow == fast
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1};
        ListNode node = new ListNode(arr);
        boolean b = hasCycle2(node);
        System.out.println(b);
    }
}
