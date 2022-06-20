package LeetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-06-17-19:55
 */
public class LC49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        List<List<String>> lists = solution49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap();
        for(String str : strs) {
            int[] charCount = new int[26];
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                charCount[c-'a']++;
            }
            for(int i = 0; i < charCount.length; i++) {
                if(charCount[i] > 0) {
                    char c = (char)('a' + i);
                    sb.append(c).append(charCount[i]);
                }
            }
            if(!map.containsKey(sb.toString())) {
                ArrayList<String> ans = new ArrayList();
                ans.add(str);
                map.put(sb.toString(),ans);
            }else{
                map.get(sb.toString()).add(str);
            }

        }
        return new ArrayList(map.values());
    }
}
