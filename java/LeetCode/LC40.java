package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-07-20-11:07
 */
public class LC40 {
}


class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        Arrays.sort(candidates);

        backtrack(res, track, candidates, target, 0, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int[] candidates, int target, int cur, int curSum) {
        if (curSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }

        if (curSum > target) {
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            if (i > cur && candidates[i-1] == candidates[i]){
                continue;
            }
            track.addLast(candidates[i]);
            backtrack(res, track, candidates, target, i+1, curSum+candidates[i]);
            track.removeLast();
        }
    }
}
