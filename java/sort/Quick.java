package sort;

import java.util.Random;

/**
 * @author zhangqingyang02
 * @date 2022-04-29-17:59
 */
public class Quick implements ISort{
    private static Random random = new Random();
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = left + random.nextInt(right - left + 1);
            swap(arr, left, index);
            int pivot = arr[left];
            int low = left + 1;
            int high = low;
            while (high <= right) {
                if (arr[high] < pivot) {
                    swap(arr, low, high);
                    low++;
                }
                high++;
            }
            quickSort(arr, left, low-1);
            quickSort(arr, low, right);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Checker.check(new Quick());
    }
}
