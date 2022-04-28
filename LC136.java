import java.util.HashMap;
import java.util.Iterator;

/**
 * @author zhangqingyang02
 * @date 2022-04-06-19:13
 */

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class LC136 {
}

//异或
class Solution136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums){
            res = res ^ num;
        }
        return res;
    }
}
//时间复杂度 O（n） 空间复杂度 O（n）
//class Solution {
//    public int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (map.get(nums[i]) == null){
//                map.put(nums[i],1);
//            }else if (map.get(nums[i]) == 1){
//                map.put(nums[i], 2);
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (map.get(nums[i]) == 1){
//                return nums[i];
//            }
//        }
//        return nums[0];
//    }
//}
