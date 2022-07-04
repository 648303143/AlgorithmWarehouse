package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangqingyang
 * @date 2022-07-04-18:43
 */
public class LC56 {
    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] merge = solution56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] ints : merge) {
            System.out.print(Arrays.toString(ints));
        }
    }
}

class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                res.add(new int[]{left, right});
                left = interval[0];
                right = interval[1];
            } else {
                right = Math.max(right, interval[1]);
            }
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);
    }

}
