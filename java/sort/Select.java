package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangqingyang02
 * @date 2022-04-28-16:10
 */
public class Select implements ISort{
    @Override
    public void sort(int[] arr) {
        if (arr==null || arr.length < 2) {
            return;
        }
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

}
