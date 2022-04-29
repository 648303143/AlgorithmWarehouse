package LeetCode; /**
 * @author zhangqingyang02
 * @date 2022-04-12-19:03
 */

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作
 */
public class LC283 {
}

class Solution283 {

    public void moveZeroes(int[] nums) {
        if (nums == null){
            return;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }


    //    public void moveZeroes(int[] nums) {
//        boolean flag = true;
//        int zeroNum = 0;
//        for (int num : nums) {
//            if (num == 0) {
//                zeroNum++;
//            }
//        }
//        for (int i = 0; i < zeroNum; i++) {
//            for (int j = 0; j < nums.length - i - 1; j++) {
//                if (nums[j] == 0) {
//                    flag = false;
//                    swap(nums, j, j + 1);
//                }
//            }
//            if (flag) {
//                break;
//            }
//        }
//    }
//
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}