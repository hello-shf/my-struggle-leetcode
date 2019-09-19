package l112;

/**
 * 描述：112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 *#112. 路径总和
 *                 3
 * 1，坑：类似   /
 *              2
 *    3不是叶子节点，所以要注意
 * 思路：
 * 1，利用前序遍历的 从根节点到叶子结点的 特性，进行累加操作
 * 2，小技巧：如果当前累加值cur == sum则返回 false，确保只要有一个路径为false，则一定能返回false
 * @Author shf
 * @Date 2019/9/19 9:33
 * @Version V1.0
 **/
public class Solution {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        return !hasPathSum(root, sum, 0);
    }
    public static boolean hasPathSum(TreeNode root, int sum, int cur) {
        if(root == null){
            return true;
        }
        cur += root.val;
        if(root.left == null && root.right == null) {
            return sum == cur ? false : true;
        }
        return hasPathSum(root.left, sum, cur) && hasPathSum(root.right, sum, cur);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.add(-3);
        /*root.add(0);
        root.add(2);
        root.add(6);
        root.add(5);
        root.add(7);*/
        boolean b = hasPathSum(root, -5);
        System.out.println(b);
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