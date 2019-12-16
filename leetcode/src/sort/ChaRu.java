package sort;

/**
 * 描述：插入排序
 * 核心思想：从头到尾逐个排序
 *
 * @Author shf
 * @Date 2019/12/13 17:37
 * @Version V1.0
 **/
public class ChaRu {
    private static void charu(int[] arr){
        int preIndex, cur;
        for(int i = 1; i< arr.length; i++){
            preIndex = i - 1;
            cur = arr[i];
            while (preIndex >= 0 && arr[preIndex] > cur){
                arr[preIndex + 1] = arr[preIndex];
                preIndex --;
            }
            arr[preIndex+1] = cur;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,2,6,1};
        charu(arr);
        for (int num : arr){
            System.out.println(num);
        }
    }
}
