package BruteForceRecursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-06-02-18:02
 */
public class AllSubsequences {
    public static void main(String[] args) {
        AllSubsequences allSubsequences = new AllSubsequences();
        String[] out = allSubsequences.getAllSubs("aba");

        for (String s : out) {
            System.out.println(s);
        }
    }

    public String[] getAllSubs (String s) {
        if (s == null) {
            return null;
        }
        ArrayList<String> res = new ArrayList<>();
        process(s, 0, "", res);

        return res.toArray(new String[0]);
    }

    public void process(String s, int index, String preStr, List<String> res) {
        if (index >= s.length()) {
            if ("".equals(preStr)) {
                return;
            }
            res.add(preStr);
            return;
        }
        process(s, index + 1, preStr, res);
        process(s, index + 1, preStr + s.charAt(index), res);

    }
}
