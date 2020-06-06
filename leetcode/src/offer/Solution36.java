package offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 描述：面试题36. 二叉搜索树与双向链表
 * 思路：
 * 1，二叉树的非递归中序遍历
 * 2，在中序遍历中将节点push到queue中
 * 3，循环queue按照顺序改变链表的left和right指针
 * 4，定义right指针是顺时针，left指针是逆时针
 *
 * @Author shf
 * @Date 2020/5/30 18:08
 * @Version V1.0
 **/
public class Solution36 {
    public static Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Stack<Node> stack = new Stack<>();
        LinkedList<Node> queue = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            queue.add(root);
            root = root.right;
        }
        Node head = queue.peek();
        Node node = head;
        while (!queue.isEmpty()){
            Node next = queue.remove();
            node.right = next;
            next.left = node;
            node = node.right;
        }
        node.right = head;
        head.left = node;
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node2 = new Node(2, node1, node3);
        Node node4 = new Node(4, node2, node5);
        Node node = treeToDoublyList(node4);
        System.out.println();
    }
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
