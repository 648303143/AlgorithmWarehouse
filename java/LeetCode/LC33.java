package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-06-15-19:46
 */
public class LC33 {
    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}

class Solution33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[0] <= nums[mid]) {
                if(target > nums[0] && target < nums[mid]) {
                    right = mid-1;
                }else {
                    left = mid + 1;
                }
            }else {
                if(target < nums[0] && target > nums[mid]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
