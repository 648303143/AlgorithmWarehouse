package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-07-20-11:46
 */
public class LC47 {
}


class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(res, track, nums, used);
        return res;
    }

    private void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int[] nums, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            if (i > 0 && nums[i-1] == nums[i] && !used[i-1]) {
                continue;
            }

            track.addLast(nums[i]);
            used[i] = true;
            backtrack(res, track, nums, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
