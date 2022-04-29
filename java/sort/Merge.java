package sort;

/**
 * @author zhangqingyang02
 * @date 2022-04-29-16:12
 */

/**
 * merge可用于的题目：
 * 小和、
 */
public class Merge implements ISort{
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        partition(arr, 0, arr.length-1);
    }

    /*
    T(n) = 2T(n/2) + O(n)
    log(2,2) = 1 = d
    -> 时间复杂度 O（nlogn）
     */

    private void partition(int[] arr, int left, int right) {
        if (left - right >= 0){
            return;
        }
        int mid = left + ((right - left) >> 1);
        partition(arr, left, mid);
        partition(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int point = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            temp[point++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
        }
        while (l <= mid){
            temp[point++] = arr[l++];
        }
        while (r <= right) {
            temp[point++] = arr[r++];
        }
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        Checker.check(new Merge());
    }
}
