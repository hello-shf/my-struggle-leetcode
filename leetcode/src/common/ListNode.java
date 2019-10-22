package common;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/10/22 21:08
 * @Version V1.0
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
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
