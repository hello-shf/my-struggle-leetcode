package l2;

import common.ListNode;

import java.util.ArrayList;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/8/8 6:46
 * @Version V1.0
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> list = new ArrayList<>();
        add(l1, l2, list);
        ListNode root = null;
        // 6 10 7
        for (int i = list.size() - 1; i >= 0; i--) {
            int val = 0;
            if (i != 0) {
                val = list.get(i-1)/10 + list.get(i)%10;
            } else {
                val = list.get(i)%10;
            }
            ListNode cur = new ListNode(val);
            cur.next = root;
            root = cur;
        }
        return root;
    }
    public void add(ListNode l1, ListNode l2, ArrayList<Integer> list){
        if(l1 == null && l2 == null){
            return;
        }
        if(l1 == null){
            list.add(l2.val);
            add(null, l2.next, list);
        } else if(l2 == null){
            list.add(l1.val);
            add(l1.next, null, list);
        } else{
            list.add(l1.val + l2.val);
            add(l1.next, l2.next, list);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 3};
        ListNode listNode1 = new ListNode(arr1);
        System.out.println(listNode1);
        int[] arr2 = {5, 6, 4};
        ListNode listNode2 = new ListNode(arr2);
        System.out.println(listNode2);
        Solution solution = new Solution();
        ListNode listNode3 = solution.addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode3);
    }
}

