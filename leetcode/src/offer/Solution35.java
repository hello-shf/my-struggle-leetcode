package offer;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/5/23 23:13
 * @Version V1.0
 **/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution35 {
    /**
     *  ------------
     * |           |
     * 1 - 2 - 3 - 4
     *  ------------------------------
     * |                             |
     * 1 - (1) - 2 - (2) - 3 - (3) - 4 - (4)
     * @param head
     */
    public static void copy(Node head){

        while (head != null){
            Node cnode = new Node(head.val);
            Node next = head.next;
            head.next = cnode;
            cnode.next = next;
            //循环
            head = cnode.next;
        }
    }

    /**
     *  ------------------------------
     * |                             |
     * 1 - (1) - 2 - (2) - 3 - (3) - 4 - (4)
     *
     *       ------------------------------
     *      |                             |
     * 1 - (1) - 2 - (2) - 3 - (3) - 4 - (4)
     * @param head
     */
    public static void random(Node head){
        while (head != null){
            Node cnode = head.next;
            if(head.random != null){
                Node crandom = head.random;
                cnode.random = crandom.next;
            }
            head = cnode.next;
        }
    }

    public static Node recombin(Node head){
        Node cnode = head.next;
        Node chead = cnode;
        head.next = cnode.next;
        head = head.next;
        while(head!=null){
            cnode.next = head.next;
            head.next = head.next.next;
            head = head.next;
            cnode = cnode.next;
        }
        return chead;
    }
    public static Node copyRandomList(Node head){
        if(head==null){
            return null;
        }
        copy(head);
        random(head);
        return recombin(head);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        Node root = copyRandomList(node);

        System.out.println(root == node);
    }
}
