package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/5/17 19:01
 * @Version V1.0
 **/
public class Solution32_3 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<LinkedList<TreeNode>> queues = new LinkedList<>();
        queues.add(queue);
        //外层循环循环 queues，queues中每一个节点是二叉树一层的queue
        while (!queues.isEmpty()){
            queue = ((LinkedList<LinkedList<TreeNode>>) queues).poll();
            LinkedList<TreeNode> nqueue = new LinkedList<>();
            LinkedList<Integer> result = new LinkedList<>();
            //内层循环queue 同BFS
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(results.size() % 2 == 0) result.add(node.val);
                else result.push(node.val);
                if(node.left != null) nqueue.add(node.left);
                if(node.right != null) nqueue.add(node.right);
            }
            if(result.size() != 0) results.add(result);
            if(!nqueue.isEmpty()) queues.add(nqueue);
        }
        return results;
    }
    public static List<List<Integer>> levelOrder_1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.add(node.val);
                else tmp.push(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.add(6);
        root.add(4);
        root.add(7);
        root.add(15);
        root.add(14);
        root.add(16);
        List<List<Integer>> list = levelOrder_1(root);
        System.out.println(list.size());
    }
}
