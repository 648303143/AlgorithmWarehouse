package LeetCode;

import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-07-22-11:22
 */
public class LC25 {
}

class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode n1 = head;
        ListNode n2 = head;

        for (int i = 0; i < k; i++) {
            if (n2 == null) {
                return head;
            }
            n2 = n2.next;
        }

        ListNode newHead = reverse(n1, n2);
        n1.next = reverseKGroup(n2, k);

        return newHead;
    }

    public ListNode reverse(ListNode head, ListNode tail){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        pre.next = cur;

        while (cur != tail) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        return pre;
    }
}
