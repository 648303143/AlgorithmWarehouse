package LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhangqingyang
 * @date 2022-07-20-15:13
 */
public class LC23 {
}

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return new ListNode();
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(p2 -> p2.val));

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            p.next = cur;
            p = p.next;
            if (cur.next != null){
                queue.add(cur.next);
            }
        }

        return dummy.next;
    }
}
