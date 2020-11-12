package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：剑指offer 48 最长不含重复字符的子字符串
 * hash表
 * 双指针 + hash表（滑窗算法）
 *
 *
 *
 * @Author shf
 * @Date 2020/6/27 18:31
 * @Version V1.0
 **/
public class Solution48 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, i = -1;
        for(int j = 0; j < s.length(); j ++){
            if(map.containsKey(s.charAt(j)))
                i = Math.max(i, map.get(s.charAt(j)));//更新左指针
            map.put(s.charAt(j), j);//更新hash表
            max = Math.max(max, j - i);//更新最大值
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abccba";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
