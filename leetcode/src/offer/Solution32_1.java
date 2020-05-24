package offer;

import common.TreeNode;

import java.util.*;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/5/16 12:17
 * @Version V1.0
 **/
public class Solution32_1 {
    public static int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node != null){
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        int[] array = new int[list.size()];
        for(int i = 0; i<array.length; i++){
            array[i] = list.get(i);
        }
//        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.add(2);
        root.add(4);
        root.add(1);
        int[] ints = levelOrder(root);
        System.out.println(ints);
    }
}
