package offer;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：从尾到头打印链表
 * 输入一个链表的头结点，按照 从尾到头 的顺序返回节点的值。
 *
 * 返回的结果用数组存储。
 *
 * 样例
 * 输入：[2, 3, 5]
 * 返回：[5, 3, 2]
 *
 * @Author shf
 * @Date 2019/11/6 21:51
 * @Version V1.0
 **/
public class Solution6 {
    public static int[] printListReversingly(ListNode head) {
        List<Integer> list = new ArrayList<>();
        printListReversingly(head, list);
        int[] nums = new int[list.size()];
        for(int i =0; i<list.size(); i++)
            nums[i] = list.get(i);
        return nums;
    }
    public static void printListReversingly(ListNode head, List<Integer> list) {
        if(head == null){
            return;
        }
        printListReversingly(head.next, list);
        //递归语句之后，即递归深度 --，递归语句之前递归深度 ++ 的天然特性。即在递归语句之后，链表是从尾到头的顺序。
        list.add(head.val);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode root = new ListNode(arr);
        int[] ints = printListReversingly(root);
        for (int i : ints)
            System.out.print(i);
        System.out.println();
    }
}
