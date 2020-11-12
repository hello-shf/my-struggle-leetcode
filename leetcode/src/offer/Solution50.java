package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/6/27 20:54
 * @Version V1.0
 **/
public class Solution50 {
    public static char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char cr : chars)
            map.put(cr, map.containsKey(cr));
        for(char cr : chars)
            if(!map.get(cr))
                return cr;
        return ' ';
    }

    public static void main(String[] args) {
        String s = "leetcode";
        char c = firstUniqChar(s);
        System.out.println();
    }
}
