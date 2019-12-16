package sort;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/12/13 18:13
 * @Version V1.0
 **/
public class FastSort {
    private static void fast(int[] arr){
        fast(arr, 0, arr.length - 1);
    }
    private static void fast(int[] arr, int l, int r){
        if (l < r){
            int midIndex = getMidIndex(arr, l, r);
            fast(arr, l, midIndex - 1);
            fast(arr, midIndex + 1, r);
        }
    }
    private static int getMidIndex(int[] arr, int l, int r){
        int mid = arr[l];
        while (l < r){
            while (l < r && arr[r] >= mid)
                r --;
            arr[l] = arr[r];
            while (l < r && arr[l] <= mid)
                l ++;
            arr[r] = arr[l];
        }
        arr[l] = mid;
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,2,6,1};
        fast(arr);
        for (int num : arr){
            System.out.println(num);
        }
    }
}
