/**
 * @author zhangqingyang02
 * @date 2022-04-13-20:02
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
public class LC448 {
}

class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = (nums[i]-1) % nums.length;
            nums[n] = nums[n]+nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length){
                res.add(i+1);
            }
        }
        return res;

    }

//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            set.add(i+1);
//        }
//        for (int num : nums) {
//            set.remove(num);
//        }
//        return new ArrayList<>(set);
//
//    }
}