package LeetCode;

import java.util.HashMap;
import java.util.Random;

/**
 * @author zhangqingyang
 * @date 2022-07-26-15:32
 */
public class LC710 {
}

class Solution710 {
    HashMap<Integer, Integer> map;
    Random random;
    int end;


    public Solution710(int n, int[] blacklist) {
        random = new Random();
        map = new HashMap<>(blacklist.length);
        for (int i : blacklist) {
            map.put(i, -1);
        }

        end = n - blacklist.length;
        int last = n-1;

        for (int i : blacklist) {
            if (i >= end) {
                continue;
            }
            while (map.containsKey(last)) {
                last--;
            }
            map.put(i, last);
            last--;
        }
    }

    public int pick() {
        int num = random.nextInt(end);
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return num;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
