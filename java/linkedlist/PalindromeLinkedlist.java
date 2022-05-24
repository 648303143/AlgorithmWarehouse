package linkedlist;

/**
 * @author zhangqingyang02
 * @date 2022-05-19-13:35
 * 判断是否是回文链表
 */
public class PalindromeLinkedlist {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode6;
//        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        boolean palindrome = isPalindrome(listNode1);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = slow;
        ListNode cur = slow.next;
        ListNode temp = null;
        slow.next = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        ListNode left = head;
        ListNode right = pre;
        boolean flag = true;
        while (left != null && right != null) {
            if (left.val != right.val) {
                flag = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        while (cur != null) {
            pre = cur.next;
            cur.next = temp;
            temp = cur;
            cur = pre;
        }
        return flag;
    }
}
