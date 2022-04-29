package LeetCode;

/**
 * @author zhangqingyang02
 * @date 2022-04-21-19:44
 */
public class LC21 {
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

//    public LeetCode.ListNode mergeTwoLists(LeetCode.ListNode list1, LeetCode.ListNode list2) {
//        if (list1 == null) {
//            return list2;
//        }
//        if (list2 == null) {
//            return list1;
//        }
//        LeetCode.ListNode l1 = list1;
//        LeetCode.ListNode l2 = list2;
//        LeetCode.ListNode pre = new LeetCode.ListNode();
//        LeetCode.ListNode cur = pre;
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val){
//                cur.next = l1;
//                l1 = l1.next;
//            }else {
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = l1 == null ? l2 : l1;
//        return pre.next;
//    }
}