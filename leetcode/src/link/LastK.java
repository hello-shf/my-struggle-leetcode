package link;

/**
 * 描述：链表倒数第k个元素
 *
 * @Author shf
 * @Date 2019/9/17 11:05
 * @Version V1.0
 **/
public class LastK {
    public static int lastK(ListNode root, int k){
        ListNode node = root;
        node = lastK(root, node, k, 0);
        return node.val;
    }
    // index 和 k两个指针相差 k 个元素
    private static ListNode lastK(ListNode root, ListNode nodeK, int k, int index){
        if(root == null){// 当index指针遍历到了尾部，也就说明找到了倒数第k个元素，返回。
            return nodeK;
        }
        index ++;
        //当 index - k > 0 即第二个指针能取到值得时候，开始递归第二个元素
        // 保证index 和 k两个指针相差 k 个元素。
        if(index - k > 0){
            nodeK = nodeK.next;
        }
        return lastK(root.next, nodeK, k, index);
    }
    public static int lastK1(ListNode root, int k){
        ListNode node = root;
        node = lastK1(root, node, -k, 0);
        return node.val;
    }
    private static ListNode lastK1(ListNode root, ListNode nodeK, int k, int index){
        if(root == null){
            return nodeK;
        }
        index ++;
        k ++;
        if(k > 0){//当 k > 0 即当能取到 k 的时候，开始递归第二个指针
            nodeK = nodeK.next;
        }
        return lastK1(root.next, nodeK, k, index);
    }

    public static int lastK2(ListNode root, int k){
        k = -k;
        ListNode nodeK = root;
        while (root.next != null){
            if(++ k >= 0){
                nodeK = nodeK.next;
            }
            root = root.next;
        }
        return nodeK.val;
    }
    public static void main(String[] args) {
        int[] aa = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode root = new ListNode(aa);
        int i = lastK2(root, 3);
        System.out.println(i);
    }

}
class ListNode {
    int val;
    public ListNode next;
    ListNode(int x) {
        this.val = x;
    }
    public ListNode(int[] arr){

        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1 ; i < arr.length ; i ++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while(cur != null){
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}