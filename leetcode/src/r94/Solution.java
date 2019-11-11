package r94;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
public class Solution{
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
