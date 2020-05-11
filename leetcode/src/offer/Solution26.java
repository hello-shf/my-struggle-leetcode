package offer;

import common.TreeNode;


/**
 * 描述：面试题26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * @Author shf
 * @Date 2020/5/3 12:33
 * @Version V1.0
 **/
public class Solution26 {
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (compare(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    public static boolean compare(TreeNode aTree, TreeNode bTree){
        if(bTree == null) {
            return true;
        }
        if(aTree == null || aTree.val != bTree.val){
            return false;
        }
        return compare(aTree.left, bTree.left) && compare(aTree.right, bTree.right);
    }

    public static void main(String[] args) {
        TreeNode nodea = new TreeNode(6);
        nodea.add(4);
        nodea.add(1);
        nodea.add(7);
        nodea.add(5);

        TreeNode nodeb = new TreeNode(4);
        nodeb.add(1);

        System.out.println(isSubStructure(nodea, nodeb));
    }
}
