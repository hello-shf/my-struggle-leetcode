package l111;

/**
 * 描述：111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 *
 *
 * 采坑记录： 当树是这个情况的时候：
 *      1
 *    /
 *  0
 *
 *
 * @Author shf
 * @Date 2019/9/18 9:21
 * @Version V1.0
 **/
public class Solution {
    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        minDepth(root, 0);
        return minDepth;
    }
    public void minDepth(TreeNode root, int depth){
        if(root == null){
            return;
        }
        if(depth > minDepth){
            return;
        }
        ++ depth;
        minDepth(root.right, depth);
        minDepth(root.left, depth);
        if(root.left == null && root.right == null){
            minDepth = Math.min(depth, minDepth);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        /*node.add(1);
        node.add(6);
        node.add(5);
        node.add(7);
        node.add(0);*/
        Solution solution = new Solution();
        int boo = solution.minDepth(node);
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
/**
 #111. 二叉树的最小深度
 思路：
 1，利用递归深度计算每个叶子节点的层级，然后通过对比缓存的minDepth 和 当前的层级对比，取小。
 */