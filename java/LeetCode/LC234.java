package LeetCode;

/**
 * @author zhangqingyang02
 * @date 2022-04-08-20:51
 */

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false
 */
public class LC234 {
}

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode preHalfTail = findPreHalfTail(head);
        ListNode lastHalfHead = reverseList(preHalfTail.next);

        ListNode preHalf = head;
        ListNode lastHalf = lastHalfHead;
        while (lastHalf != null){
            if (preHalf.val != lastHalf.val){
                return false;
            }
            preHalf = preHalf.next;
            lastHalf = lastHalf.next;
        }
        ListNode preHalfTailNext = reverseList(lastHalfHead);
        preHalfTail.next = preHalfTailNext;

        return true;


    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = null;
        ListNode after = head;
        while (after != null) {
            pre = cur;
            cur = after;
            after = after.next;
            cur.next = pre;
        }
        return cur;
    }

    private ListNode findPreHalfTail(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}