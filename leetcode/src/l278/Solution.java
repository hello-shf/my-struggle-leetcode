package l278;


/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/9/28 17:46
 * @Version V1.0
 **/
public class Solution {
    public static int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l < r){
            int middle = (r + l)/ 2;
            if(isBadVersion(middle)){
                r = middle;
            }else{
                l = middle + 1;
            }
        }
        return l;
    }
    public static boolean isBadVersion(int version){
        if(version < 6){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        int i = firstBadVersion(8);
        System.out.println(i);

    }
}
