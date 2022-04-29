package LeetCode; /**
 * @author zhangqingyang02
 * @date 2022-04-07-20:49
 */

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class LC206 {
}
class Solution206 {

    /**
     * 递归
     * 时间空间 ：o（n）
     */
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode n = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return n;
    }
    /**
     * 三指针
     * 时间： O（n）
     * 空间： O（1）
     */
//    public LeetCode.ListNode reverseList(LeetCode.ListNode head) {
//        LeetCode.ListNode pre = null;
//        LeetCode.ListNode cur = null;
//        LeetCode.ListNode after = head;
//        while (after != null){
//            pre = cur;
//            cur = after;
//            after = after.next;
//            cur.next = pre;
//        }
//        return cur;
//    }
}