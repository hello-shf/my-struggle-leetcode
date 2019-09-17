package l110;


/**
 * 描述：leetcode 110 判断二叉树是否是平衡二叉树
 *
 *给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 *
 *
 * 思路：
 * 1，递归
 * 2，利用递归函数后面就是出栈过程，及是树的自底向上的过程
 * 3，在自底向上的过程中逐层计算height，当前节点取左右子树较高的那棵的高度值 + 1
 * 4，判断如果出现 l - r 的高度的绝对值大于1的情况则将balanced置为false；
 *
 * @Author shf
 * @Date 2019/7/31 16:47
 * @Version V1.0
 **/
public class Solution {
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        getHeight(root);
        return balanced;
    }
    public Integer getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        balanced = Math.abs(l - r) > 1 ? false && balanced : true && balanced;
        return Math.max(l, r) + 1;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.add(1);
        node.add(6);
        node.add(5);
        node.add(7);
        Solution solution = new Solution();
        boolean boo = solution.isBalanced(node);
        System.out.println(boo);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){

    }
    TreeNode(int x) {
        val = x;
        this.left = null;
        this.right = null;
    }
    public void add(int val){
        add(this, val);
    }
    public TreeNode add(TreeNode node, int val){
        if(node == null){
            return new TreeNode(val);
        }
        if(val > node.val){
            node.right = add(node.right, val);
        }else{
            node.left = add(node.left, val);
        }
        return node;
    }
}
