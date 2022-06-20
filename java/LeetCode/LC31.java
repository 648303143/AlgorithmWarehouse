package LeetCode;

import java.util.Arrays;

/**
 * @author zhangqingyang
 * @date 2022-06-15-12:33
 */
public class LC31 {
    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int[] nums = new int[]{1,3,2};
        solution31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }


}

class Solution31 {
    boolean flag = false;

    public void nextPermutation(int[] nums) {

        findMinRange(nums, 0);
        if(!flag) {
            Arrays.sort(nums);
        }
    }


    public void findMinRange(int[] nums, int cur) {
        if(cur >= nums.length - 1){
            return;
        }


        findMinRange(nums, cur + 1);

        if(flag) {
            return;
        }
        for(int i = nums.length - 1; i > cur; i--) {
            if(nums[i] > nums[cur]) {
                swap(nums, i, cur);
                flag = true;
                break;
            }
        }
        if(flag) {
            Arrays.sort(nums, cur+1, nums.length);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
