package LeetCode;

import java.util.Arrays;

/**
 * @author zzzZqy
 * @create 2021-10-02 14:48
 */
/*
215. 数组中的第K个最大元素 middle
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class LC215 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k =2;
        Arrays.sort(nums);
        System.out.println(nums[nums.length-k]);
    }
}
