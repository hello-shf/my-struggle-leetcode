package sort;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/12/13 18:02
 * @Version V1.0
 **/
public class Shell {
    private static void shell(int[] arr){
        int len = arr.length, gap = 1;
        if(gap < len / 3){
            gap = gap * 3 + 1;
        }
        while(gap > 0){
            for(int i = gap; i < len; i++){
                int preIndex = i - gap;
                int cur = arr[i];
                while(preIndex >= 0 && arr[preIndex] > cur){
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = cur;
            }
            gap = gap / 3;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,2,6,1};
        shell(arr);
        for (int num : arr){
            System.out.println(num);
        }
    }
}
