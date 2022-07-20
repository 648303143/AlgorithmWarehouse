package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-07-20-14:38
 */
public class LC216 {
}


class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        backtrack(res, track, k, n, 1, 0);

        return res;
    }

    private void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int k, int n, int cur, int preSum) {
        if (preSum > n) {
            return;
        }
        if (track.size() > k) {
            return;
        }
        if (preSum == n && track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = cur; i <= 9; i++) {
            track.addLast(i);
            backtrack(res, track, k, n, i+1, preSum+i);
            track.removeLast();
        }
    }
}
