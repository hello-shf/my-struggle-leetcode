package common;
/**
 * 描述：leetcode 144 二叉树的前序遍历  145 二叉树的后序遍历
 *
 * @Author shf
 * @Date 2019/7/24 10:13
 * @Version V1.0
 **/

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){

    }
    public TreeNode(int x) {
        val = x;
    }
    /**
     * 添加数据
     * @param val
     */
    public void add(int val) {
        add(this, val);
    }
    public TreeNode add(TreeNode node, int val){
        if(node == null){
            return new TreeNode(val);
        }
        //将等于的情况优先放到为空的孩子节点上，否则按照 左孩子-右孩子 的顺序插入
        if(val == node.val && node.left == null)
            node.left = add(node.left, val);
        else if(val == node.val && node.right == null)
            node.right = add(node.right, val);
        else if(val < node.val)
            node.left = add(node.left, val);
        else if(val > node.val)
            node.right = add(node.right, val);
        return node;
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(this);
    }
    private void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(this);
    }
    private void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}