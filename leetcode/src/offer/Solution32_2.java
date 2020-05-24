package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：面试题32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 *
 * 思路：
 * 建立一个双层的queue，也就是外层装二叉树每层的node，内层的queue装二叉树的每个节点
 * 外层循环外层的queue，每次循环处理二叉树的一层节点，内循环处理二叉树的节点。
 *
 * @Author shf
 * @Date 2020/5/17 18:44
 * @Version V1.0
 **/
public class Solution32_2 {
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
            List<Integer> result = new ArrayList<>();
            //内层循环queue 同BFS
            while (!queue.isEmpty()){
                TreeNode node = queue.remove();
                result.add(node.val);
                if(node.left != null){
                    nqueue.add(node.left);
                }
                if(node.right != null){
                    nqueue.add(node.right);
                }
            }
            if(result.size() != 0){
                results.add(result);
            }
            if(!nqueue.isEmpty()){
                queues.add(nqueue);
            }
        }
        return results;
    }

    /**
     * 内层用for替代while，将可省去queues
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder_1(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //外层循环循环 queues，queues中每一个节点是二叉树一层的queue
        while (!queue.isEmpty()){
            List<Integer> result = new ArrayList<>();
            //内层循环queue 同BFS
            for (int i = queue.size(); i> 0; i--){
                TreeNode node = queue.poll();
                result.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(result.size() != 0){
                results.add(result);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.add(2);
        root.add(4);
        root.add(1);
        List<List<Integer>> list = levelOrder_1(root);
        System.out.println(list.size());
    }
}
