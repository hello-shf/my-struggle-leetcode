package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/5/23 22:20
 * @Version V1.0
 **/
public class Solution34 {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<List<Integer>> re = new LinkedList<>();
        LinkedList<Integer> tre = new LinkedList<>();
        if(root == null){
            return re;
        }
        inOrder(root, re, tre, 0, sum);
        return re;
    }
    public static void inOrder(TreeNode root, LinkedList<List<Integer>> re, LinkedList<Integer> tre, int tmp, int sum){
        if(root == null){
            return ;
        }
        tre.add(root.val);
        tmp += root.val;
        if (tmp == sum && root.left == null && root.right == null) {
            re.add(new LinkedList<>(tre));
        }
        inOrder(root.left, re, tre, tmp, sum);
        inOrder(root.right, re, tre, tmp, sum);
        tre.removeLast();
        //到最后一行说明到了一个叶子节点
    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(15);
        root.add(10);
        root.add(5);
        root.add(2);
        root.add(12);
        root.add(11);
        root.add(14);
        root.add(20);
        root.add(18);
        root.add(25);*/
        TreeNode root = new TreeNode(-2);
        root.add(1);
        root.add(-3);

        List<List<Integer>> list = pathSum(root, -5);
        System.out.println(list.size());
    }
}
