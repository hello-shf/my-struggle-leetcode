package offer;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2020/4/18 20:30
 * @Version V1.0
 **/
public class Solution20 {
    public boolean isNumber(String s) {
        return s.trim().matches("[+-]?(\\d+[.]\\d*|\\d*[.]\\d+|\\d+)([eE][+-]?\\d+)?");
    }
}
