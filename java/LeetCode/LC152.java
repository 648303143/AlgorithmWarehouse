package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-06-16-11:52
 */
public class LC152 {
    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        System.out.println(solution152.maxProduct(new int[]{2, 3, -2, 4}));
    }
}

class Solution152 {
    public int maxProduct(int[] nums) {
        int preMax = 1;
        int preMin = 1;
        int max = nums[0];
        for (int num : nums) {
            if (num < 0) {
                int temp = preMax;
                preMax = preMin;
                preMin = temp;
            }

            preMax = Math.max(preMax * num, num);
            preMin = Math.min(preMin * num, num);

            max = Math.max(preMax, max);
        }
        return max;
    }
}
