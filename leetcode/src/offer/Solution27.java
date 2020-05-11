package offer;

import common.TreeNode;

/**
 * 描述：面试题27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 *
 * 思路：递归交换左右子节点
 *
 * @Author shf
 * @Date 2020/5/3 13:34
 * @Version V1.0
 **/
public class Solution27 {
    public static TreeNode mirrorTree(TreeNode root) {
        swap(root);
        return root;
    }
    public static void swap(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        swap(root.left);
        swap(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(6);
        node.add(4);
        node.add(1);
        node.add(5);
        node.add(8);
        node.add(7);
        node.add(9);
        node.preOrder();
        System.out.println("-------");
        node.postOrder();
        TreeNode treeNode = mirrorTree(node);
        System.out.println();
    }
}
