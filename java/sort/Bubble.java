package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangqingyang02
 * @date 2022-04-28-16:10
 */
public class Bubble {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);

                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    @Test
    public void test() {
        int[] arr = new int[]{4, 7, 2, 3, 11, 7, 4};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
