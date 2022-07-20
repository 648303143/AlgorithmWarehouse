package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-07-20-10:25
 */
public class LC77 {
}

class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        backtrack(res, track, n, k, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int n, int k, int cur) {
        if(n-cur+1+track.size() < k) {
            return;
        }

        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = cur; i <= n; i++) {
            track.addLast(i);
            backtrack(res, track, n, k, cur+1);
            track.removeLast();
        }
    }


}
