package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-20-16:46
 */
public class LC83 {
}


class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }


        if (slow != null) {
            slow.next = null;
        }
        return head;
    }
}
