package offer;

import common.TreeNode;

/**
 * 描述：剑指 Offer 54. 二叉搜索树的第k大节点
 * 中序遍历
 * 注意：先left，后right，小——> 大
 *       先right，后left，大——> 小
 * @Author shf
 * @Date 2020/7/11 10:34
 * @Version V1.0
 **/
public class Solution54 {
    public static int kthLargest(TreeNode root, int k) {
        int[] arr = {k, 0, 0};
        inOrder(root, arr);
        return arr[2];
    }
    public static void inOrder(TreeNode node, int[] arr){
        if(node == null){
            return;
        }
        inOrder(node.right, arr);
        arr[1] += 1;
        if(arr[1] == arr[0]){
            arr[2] = node.val;
            return;
        }
        inOrder(node.left, arr);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.add(4);
        root.add(9);
        root.add(3);
        root.add(7);
        root.add(29);
        root.add(10);
        int i = kthLargest(root, 2);
        System.out.println(i);

        System.out.println("-----------------");
        root.inOrder();
    }
}
