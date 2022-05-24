package linkedlist;

/**
 * @author zhangqingyang02
 * @date 2022-05-19-16:18
 * 链表重新排列成小于某个值的在左边，等于的在中间，大于的在右边
 */
public class PartitionLinkedList {
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
        ListNode partition = partition(listNode1, 20);
        System.out.println(partition);
    }

    public static ListNode partition(ListNode head, int pivot){
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode middleHead = null;
        ListNode middleTail = null;
        ListNode largeHead = null;
        ListNode largeTail = null;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < pivot){
                if (smallHead == null) {
                    smallHead = cur;
                }else {
                    smallTail.next = cur;
                }
                smallTail = cur;
            }else if(cur.val == pivot) {
                if (middleHead == null) {
                    middleHead = cur;
                }else {
                    middleTail.next = cur;
                }
                middleTail = cur;
            }else if(cur.val > pivot) {
                if (largeHead == null) {
                    largeHead = cur;
                }else {
                    largeTail.next = cur;
                }
                largeTail = cur;
            }
            cur = cur.next;
        }

        if (smallTail != null) {
            smallTail.next = middleHead;
            middleTail = middleTail == null ? smallTail : middleTail;
        }
        if (middleTail != null) {
            middleTail.next = largeHead;
        }
        return smallHead != null ? smallHead : (middleHead != null ? middleHead : largeHead);
    }
}
