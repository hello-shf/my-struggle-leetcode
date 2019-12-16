package sort;

/**
 * 描述：选择排序
 *
 * @Author shf
 * @Date 2019/12/13 17:29
 * @Version V1.0
 **/
public class XuanZe {
    public static void xuanze(int[] arr){
        int len = arr.length, minIndex;
        for(int i = 0; i< len - 1; i++){
            minIndex = i;
            for (int j = i + 1; j< len; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,2,6,1};
        xuanze(arr);
        for (int num : arr){
            System.out.println(num);
        }
    }
}
