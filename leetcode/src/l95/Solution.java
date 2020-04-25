package l95;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/12/16 17:57
 * @Version V1.0
 **/
public class Solution {
    private static List<TreeNode> generateTrees(int n){
        List<List<TreeNode>> dp = new ArrayList<>(n);
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            list.add(new TreeNode(n));
        }
        dp.add(list);
        for (int i = 2; i <= n; i++) {
            if(dp.get(i) != null){

            }
        }
        return list;
    }
    private static TreeNode add(TreeNode root, int e){
        if(root == null){
            return new TreeNode(e);
        }
        if(e < root.val){
            root.left = add(root.left, e);
        }else{
            root.right = add(root.right, e);
        }
        return root;
    }
}
