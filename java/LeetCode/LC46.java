package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangqingyang
 * @date 2022-06-17-14:57
 */
public class LC46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        List<List<Integer>> permute = solution46.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> ans = new ArrayList();
        boolean[] used = new boolean[nums.length];
        process(nums, res, ans, used, 0);
        return res;

    }

    public void process(int[] nums, List<List<Integer>> res, List<Integer> ans, boolean[] used, int point) {
        if(point >= nums.length) {
            res.add(new ArrayList(ans));
            return;
        }

        for(int i = 0; i < used.length; i++) {
            if(!used[i]){
                ans.add(nums[i]);
                used[i] = true;
                process(nums, res, ans, used, point+1);
                used[i] = false;
                ans.remove(ans.size()-1);
            }
        }
    }


//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList();
//        List<Integer> ans = new ArrayList();
//        for (int num : nums) {
//            ans.add(num);
//        }
//        process(res, ans, 0);
//        return res;
//
//    }
//
//    public void process(List<List<Integer>> res, List<Integer> ans, int point) {
//        if(point >= ans.size()) {
//            res.add(new ArrayList(ans));
//            return;
//        }
//
//        for(int i = point; i < ans.size(); i++) {
//            Collections.swap(ans, i, point);
//
//            process(res, ans, point + 1);
//
//            Collections.swap(ans, i, point);
//        }
//    }


}
