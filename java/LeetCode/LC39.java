package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-06-17-11:38
 */
public class LC39 {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        List<List<Integer>> lists = solution39.combinationSum(new int[]{2, 3, 6, 7}, 7);
        lists.forEach(System.out::println);
    }
}

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> group = new ArrayList();
        process(candidates, 0, target, res, group, 0);
        return res;

    }

    public void process(int[] candidates, int cur, int target, List<List<Integer>> res, List<Integer> group, int preSum){
        if(cur >= candidates.length) {
            if(preSum == target) {
                res.add(new ArrayList<>(group));
            }
            return;
        }

        if(preSum + candidates[cur] <= target) {
            group.add(candidates[cur]);
            process(candidates, cur, target, res, group, preSum+candidates[cur]);
            group.remove(group.size()-1);
        }

        process(candidates, cur+1, target, res, group, preSum);

    }
}
