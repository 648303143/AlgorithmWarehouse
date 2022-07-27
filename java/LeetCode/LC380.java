package LeetCode;

import java.util.*;

/**
 * @author zhangqingyang
 * @date 2022-07-26-14:44
 */
public class LC380 {
}


class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, nums.size());
        return nums.add(val);
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Integer index = map.get(val);
        map.put(nums.get(nums.size()-1), index);
        Collections.swap(nums, index, nums.size()-1);
        nums.remove(nums.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int i = random.nextInt(nums.size());
        return nums.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
