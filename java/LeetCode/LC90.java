package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-07-20-10:48
 */
public class LC90 {
}

class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);

        backtrack(res, track, nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int[] nums, int cur) {
        res.add(new ArrayList<>(track));

        for (int i = cur; i < nums.length; i++) {
            if (i > cur && nums[i - 1] == nums[i]) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(res, track, nums, i + 1);
            track.removeLast();
        }
    }
}
