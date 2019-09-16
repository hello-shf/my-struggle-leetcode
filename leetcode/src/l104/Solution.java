package l104;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/16 17:42
 * @Version V1.0
 **/
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return maxDepth(root, 1, 1);
    }
    public int maxDepth(TreeNode root, int depth, int max){
        if(root == null){
            return max;
        }
        max = depth > max ? depth : max;
        depth ++;
        return Integer.max(maxDepth(root.left, depth, max), maxDepth(root.right, depth, max));
    }

    public static void main(String[] args) {
        int depth = 0, max = 0;
        max = depth ++ > max ? depth ++ : max;
        System.out.println(max);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
