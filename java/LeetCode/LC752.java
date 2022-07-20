package LeetCode;

import com.sun.javafx.font.directwrite.DWFactory;

import java.util.*;

/**
 * @author zhangqingyang
 * @date 2022-07-19-19:32
 */
public class LC752 {
    public static void main(String[] args) {
        Solution752 solution752 = new Solution752();
        int i = solution752.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888");
        System.out.println(i);
    }
}

class Solution752 {

    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        Collections.addAll(deads, deadends);
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // 从起点开始启动广度优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向周围扩散 */
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                /* 判断是否到达终点 */
                if (deads.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;

                /* 将一个节点的未遍历相邻节点加入队列 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            /* 在这里增加步数 */
            step++;
        }
        // 如果穷举完都没找到目标密码，那就是找不到了
        return -1;
    }

    // 将 s[j] 向上拨动一次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }

    // 将 s[i] 向下拨动一次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }

//    public int openLock(String[] deadends, String target) {
//        ArrayList<String> deadEnds = new ArrayList<>();
//        Collections.addAll(deadEnds, deadends);
//
//        Queue<String> queue = new LinkedList<>();
//        HashSet<String> visited = new HashSet<>();
//        queue.add("0000");
//        visited.add("0000");
//
//        int step = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//
//            for (int i = 0; i < size; i++) {
//                String cur = queue.poll();
//                if (deadEnds.contains(cur)) {
//                    return -1;
//                }
//                if (target.equals(cur)) {
//                    return step;
//                }
//                for (int j = 0; j < target.length(); j++) {
//                    StringBuilder curSB = new StringBuilder(cur);
//                    char point = curSB.charAt(j);
//                    char up = point == '9' ? '0' : (char) (point + 1);
//                    char down = point == '0' ? '9' : (char) (point - 1);
//                    curSB.replace(j, j + 1, String.valueOf(up));
//                    if (!visited.contains(curSB.toString())) {
//                        queue.add(new String(curSB));
//                        visited.add(new String(curSB));
//                    }
//                    curSB.replace(j, j + 1, String.valueOf(down));
//                    if (!visited.contains(curSB.toString())) {
//                        queue.add(new String(curSB));
//                        visited.add(new String(curSB));
//                    }
//                }
//            }
//            step++;
//
//        }
//        return -1;
//    }
}
