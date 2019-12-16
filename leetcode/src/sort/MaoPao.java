package sort;

/**
 * 描述：冒泡排序
 *
 * @Author shf
 * @Date 2019/12/13 17:19
 * @Version V1.0
 **/
public class MaoPao {
    public static void maopao(int[] arr){
        int len = arr.length;
        for(int i = 0; i< len - 1; i++){
            for(int j=0; j< len - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,2,6,1};
        maopao(arr);
        for (int num : arr){
            System.out.println(num);
        }
    }
}
