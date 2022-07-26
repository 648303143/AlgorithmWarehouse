package LeetCode;

/**
 * @author zhangqingyang
 * @date 2022-07-22-10:19
 */
public class LC92 {
    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        listNode3.next = listNode5;

        Solution92 solution92 = new Solution92();
        solution92.reverseBetween(listNode3, 1, 2);
    }
}

class Solution92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode preTail = pre;
        ListNode cur = pre.next;
        ListNode next = pre.next.next;

        for (int i = 1; i <= right-left; i++) {
            pre = cur;
            cur = next;
            next = next.next;
            cur.next = pre;
        }

        preTail.next.next = next;
        preTail.next = cur;

        return dummy.next;
    }


//    ListNode tail = null;
//
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if (left == 1) {
//            return reverseN(head, right);
//        }
//
//        head.next = reverseBetween(head.next, left-1, right-1);
//        return head;
//    }
//
//    public ListNode reverseN(ListNode head, int n) {
//        if (n == 1) {
//            tail = head.next;
//            return head;
//        }
//
//        ListNode last = reverseN(head.next, n-1);
//        head.next.next = head;
//        head.next = tail;
//        return last;
//    }
}


