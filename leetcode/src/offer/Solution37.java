package offer;

import common.TreeNode;

import java.util.*;

/**
 * 描述：序列化二叉树
 *
 * @Author shf
 * @Date 2020/5/30 18:58
 * @Version V1.0
 **/
public class Solution37 {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node != null){
                result.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            }else{
                result.add("null");
            }
        }
        return result.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.add(2);
        root.add(8);
        root.add(6);
        root.add(10);
        root.add(9);
        String str = serialize(root);
        System.out.println();
    }
}
