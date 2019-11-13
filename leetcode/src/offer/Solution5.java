package offer;

/**
 * 描述：替换空格
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。
 *
 * 你可以假定输入字符串的长度最大是1000。
 * 注意输出字符串的长度可能大于1000。
 *
 * @Author shf
 * @Date 2019/11/6 21:32
 * @Version V1.0
 **/
public class Solution5 {
    public static String replaceSpaces(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        char[] chars = str.toString().toCharArray();
        for (Character cha : chars) {
            if (cha == ' ') {
                sb.append("%20");
            }else{
                sb.append(cha);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We are happy.");
        String s = replaceSpaces(sb);
        System.out.println(s);
    }
}
