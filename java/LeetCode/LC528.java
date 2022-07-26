package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author zhangqingyang
 * @date 2022-07-25-17:50
 */
public class LC528 {
}


class Solution528 {

    int[] arr;

    public Solution528(int[] w) {
        int len = 0;
        for (int i : w) {
            len += i;
        }
        arr = new int[len];
        int index = 0;
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i]; j++) {
                arr[index++] = i;
            }
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int index = random.nextInt(arr.length);
        return arr[index];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
