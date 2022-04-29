package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangqingyang02
 * @date 2022-04-28-16:10
 */
public class Select {
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                min = arr[min] < arr[j] ? min : j;
            }
            swap(arr, i, min);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test(){
        int[] arr = new int[]{4,7,2,3,11,7,4};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
