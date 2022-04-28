/**
 * @author zhangqingyang02
 * @date 2022-04-07-19:46
 */

import java.util.Arrays;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 */
public class LC169 {
}

class Solution169 {
    /**
     * 投票法
     * 时间： O（n）
     * 空间： O（1）
     */
    public int majorityElement(int[] nums) {
        Integer more = null;
        int count = 0;
        for(int num : nums) {
            if (count == 0){
                more = num;
            }
            count += num == more ? 1 : -1;
        }
        return more;
    }

    /**
     * 排序
     * 时间 O（nlogn）
     * 空间 O（logn）
     */
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }
}