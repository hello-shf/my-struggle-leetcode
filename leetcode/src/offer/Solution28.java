package offer;

import common.TreeNode;

/**
 * 描述：面试题28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * @Author shf
 * @Date 2020/5/3 13:45
 * @Version V1.0
 **/
public class Solution28 {
    public static boolean isSymmetric(TreeNode root) {
        return preOrder(root, root);
    }

    public static boolean preOrder(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }else if(node1 == null || node2 == null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        return preOrder(node1.left, node2.right) && preOrder(node1.right, node2.left);
    }


    public static void main(String[] args) {

    }
}
