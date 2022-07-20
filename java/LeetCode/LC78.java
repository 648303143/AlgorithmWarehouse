package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangqingyang
 * @date 2022-07-05-19:01
 */
public class LC78 {
    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        List<List<Integer>> subsets = solution78.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        backtrack(res, track, 0, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, LinkedList<Integer> track, int cur, int[] nums) {

        res.add(new ArrayList(track));

        for(int i = cur; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(res, track, i+1, nums);
            track.removeLast();
        }
    }

//    public List<List<Integer>> subsets(int[] nums) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        HashSet<List<Integer>> res = new HashSet<>(3);
//        process(nums,0,ans,res);
//        return new ArrayList<>(res);
//    }
//
//    public void process(int[] nums, int cur, List<Integer> ans, HashSet<List<Integer>> res){
//        if (cur >= nums.length) {
//            ArrayList<Integer> answer = new ArrayList<>(ans);
//            res.add(answer);
//            return;
//        }
//        ans.add(nums[cur]);
//        process(nums,cur+1,ans,res);
//        ans.remove(ans.size()-1);
//
//        process(nums,cur+1,ans,res);
//
//    }
}
