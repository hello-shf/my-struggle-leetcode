package offer;


import common.TreeNode;

/**
 * 描述：重建二叉树
 * 思路：
 * 1，二叉树的前序遍历按照：父节点-左孩子-右孩子的顺序遍历
 * 2，中序遍历按照：左孩子-父节点-右孩子的顺序遍历
 * 3，综合以上两点可以清晰的发现，可以按照前序遍历来确定根节点，然后根据中序遍历，确定根节点的左孩子和右孩子。
 * 举例：
 *               7
 *            /    \
 *          3       10
 *        /  \     /  \
 *      2    4    8   11
 * 前序遍历为：【7,3,2,4,10,8,11】
 * 中序遍历为：【2,3,4,7,8,10,11】
 * 首先根据前序遍历确定根节点为 7，在中序遍历中找到 7节点，7节点左边的都是7节点的左孩子，右边的都是其右孩子。
 * 即中序遍历可以根据根节点7分为【2,3,4】&【8,10,11】两个部分。
 * 前序遍历可以根据7节点在中序遍历中的位置分为【3,2,4】&【10,8,11】两部分。
 * 根据前序遍历的特点：父-左-右可知，上一步分为的两部分的第一部分的第一个元素是7的左孩子，第二部分的第一个元素是其右孩子。
 * 然后根据这个规律递归的进行即可。
 * 注意：
 * 边界问题，无右孩子或者无左孩子。
 * @Author shf
 * @Date 2019/11/7 21:37
 * @Version V1.0
 **/
public class Solution7 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return builder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
    }
    public static TreeNode builder(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        //k为根节点在中序遍历中的位置。
        int k = findK(pre[preStart], in);
        if(k != -1){
            //左孩子在前序遍历中的范围为：preStart + 1, preStart + k - inStart
            //左孩子在中序遍历中的范围为：inStart, k - 1
            root.left = builder(pre, preStart + 1, preStart + k - inStart, in, inStart, k - 1);
            //右孩子在前序遍历中的范围为：preStart + k + 1 - inStart, preEnd
            //右孩子在中序遍历中的范围为：k + 1, inEnd
            root.right = builder(pre, preStart + k + 1 - inStart, preEnd, in, k + 1, inEnd);
        }
        return root;
    }
    public static int findK(int tar, int[] in){
        for(int i=0; i< in.length; i++){
            if(tar == in[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        /*TreeNode bst = new TreeNode(5);
        bst.add(2);
        bst.add(3);
        bst.add(6);
        bst.add(7);
        bst.add(8);
        bst.add(9);
        bst.add(4);
        System.out.println("-------------中序遍历------------");
        bst.inOrder();
        System.out.println("-------------后续遍历------------");
        bst.preOrder();*/
        int[] pre = {7,3,2,4,10,8,11};
        int[] ino = {2,3,4,7,8,10,11};
        TreeNode treeNode = buildTree(pre, ino);
        treeNode.preOrder();
    }
}
