package LeetCode;

import java.util.*;

/**
 * @author zhangqingyang
 * @date 2022-07-26-10:47
 */
public class LC870 {
    public static void main(String[] args) {
        Solution870 solution870 = new Solution870();
        int[] arr1 = new int[]{2,0,4,1,2};
        int[] arr2 = new int[]{1,3,0,0,2};
        int[] ints = solution870.advantageCount(arr1, arr2);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> record = new PriorityQueue<>(Comparator.comparingInt(arr -> -arr[1]));
        for (int i = 0; i < nums2.length; i++) {
            record.add(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);
        int[] res = new int[nums2.length];

        int left = 0;
        int right = nums1.length-1;
        while (!record.isEmpty()) {
            int[] one = record.poll();
            int index = one[0];
            int num = one[1];
            if (nums1[right] > num) {
                res[index] = nums1[right--];
            }else {
                res[index] = nums1[left++];
            }
        }

        return res;
    }
}
