package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author zhangqingyang
 * @date 2022-07-25-17:50
 */
public class LC528 {
}


class Solution528 {

    int[] preSum;
    Random random = new Random();

    public Solution528(int[] w) {
        preSum = new int[w.length+1];

        preSum[0] = 0;

        for (int i = 0; i < w.length; i++) {
            preSum[i+1] = preSum[i] + w[i];
        }

    }

    public int pickIndex() {
        int target = random.nextInt(preSum[preSum.length-1]);

        int left = 1;
        int right = preSum.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < preSum[mid]) {
                right = mid - 1;
            } else if (target >= preSum[mid]) {
                left = mid + 1;
            }
        }

        return right;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
