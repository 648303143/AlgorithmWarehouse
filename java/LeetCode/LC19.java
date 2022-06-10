package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-06-10-17:45
 */
public class LC19 {
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        cur = head;
        int times = length - n;
        if (times == 0) {
            return cur.next;
        }
        while (times > 1) {
            cur = cur.next;
            times--;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = head;
        int step = n;
        while (step > 0 && fast != null) {
            fast = fast.next;
            step--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;

        }

        return pre.next;

    }
}
