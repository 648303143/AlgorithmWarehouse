package linkedlist;

/**
 * @author zhangqingyang
 * @date 2022-05-25-19:31
 * 找到两个可能有环可能无环的链表的相交位置，不相交就为null
 */
public class IntersectionLinkedList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(45);
        ListNode listNode3 = new ListNode(22);
        ListNode listNode4 = new ListNode(16);
        ListNode listNode5 = new ListNode(77);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode3;

        ListNode l1 = new ListNode(6);
        l1.next = listNode2;
        IntersectionLinkedList intersectionLinkedList = new IntersectionLinkedList();
        ListNode intersection = intersectionLinkedList.findIntersection(l1, listNode1);
        System.out.println(intersection.val);
    }

    public ListNode findIntersection(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode loop1 = findLoop(head1);
        ListNode loop2 = findLoop(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1,head2);
        }else if (loop1 != null && loop2 != null) {
            return bothLoop(head1,head2,loop1,loop2);
        }
        return null;
    }

    public ListNode findLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode noLoop(ListNode head1, ListNode head2) {
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int difference = 0;
        while (cur1 != null) {
            cur1 = cur1.next;
            difference++;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
            difference--;
        }
        cur1 = difference >= 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        difference = Math.abs(difference);
        while (difference > 0) {
            cur1 = cur1.next;
            difference--;
        }
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    public ListNode bothLoop(ListNode head1, ListNode head2, ListNode loop1, ListNode loop2) {
        if (loop1 == loop2) {
            ListNode cur1 = head1;
            ListNode cur2 = head2;
            int difference = 0;
            while (cur1 != loop1) {
                cur1 = cur1.next;
                difference++;
            }
            while (cur2 != loop2) {
                cur2 = cur2.next;
                difference--;
            }
            cur1 = difference >= 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            difference = Math.abs(difference);
            while (difference > 0) {
                cur1 = cur1.next;
                difference--;
            }
            while (cur1 != loop1 && cur2 != loop2) {
                if (cur1 == cur2) {
                    return cur1;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return loop1;
        }else {
            ListNode n = loop1.next;
            while (n != loop1) {
                if (n == loop2) {
                    return loop1;
                }
            }
            return null;
        }
    }
}
