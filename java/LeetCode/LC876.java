package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-20-15:34
 */
public class LC876 {
}


class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
