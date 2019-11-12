package offer.array;

import common.TreeNode;

/**
 * 描述：剑指offer 8
 * 给定一棵二叉树，每个节点存在left,right,parent三个指向。给出其中一个节点，请找出中序遍历序列的下一个节点。
 * 注意：
 * 如果给定的节点是中序遍历序列的最后一个，则返回空节点;
 * 二叉树一定不为空，且给定的节点一定不是空节点；
 * 样例：
 * 假定二叉树是：[2, 1, 3, null, null, null, null]， 给出的是值等于2的节点。
 * 则应返回值等于3的节点。
 * 解释：该二叉树的结构如下，2的后继节点是3。
 *   2
 *  / \
 * 1   3
 *
 * 思路：
 * [d,b,h,e,a,f,c,g]
 *                   a
 *                /    \
 *              b       c
 *            /  \     /  \
 *          d     e   f    g
 * 正常情况：a 右孩子的最左边的孩子。
 * 特殊情况：d,e 第一个有左孩子的父节点。
 * 比如d，第一个有左孩子的父节点为b。比如e，第一个有左孩子的父节点是a
 * @Author shf
 * @Date 2019/11/12 21:30
 * @Version V1.0
 **/
public class Solution8 {
    public static TreeNode inorderSuccessor(TreeNode p) {
        if(p == null)
            return null;
        //当该节点存在右孩子，则该节点的下一个节点为 其右孩子的最左边的孩子节点。
        if(p.right != null) {
            p = p.right;
            while(p.left != null)
                p = p.left;
            return p;
        }
        //当该节点右孩子为null，则该节点的下一个节点为 其第一个有左孩子的父节点。比如：d-b,e-a
        while(p.parent != null) {
            if (p.parent.left == p)
                return p.parent;
            p = p.parent;
        }
        return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        root.add(10);
        root.add(50);
        root.add(40);
        root.add(31);
        root.add(48);
        root.add(46);
////        root.add(11);
        root.add(49);
        root.add(60);
//        root.add(16);
//        root.add(18);
        root.inOrder();
        TreeNode treeNode = inorderSuccessor(root);
        System.out.println(treeNode.val);
    }
}
