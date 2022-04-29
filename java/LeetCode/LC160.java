package LeetCode; /**
 * @author zhangqingyang02
 * @date 2022-04-07-19:19
 */

/**
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class LC160 {
}

class Solution160 {
    /**
     * 双指针，消除两个链表的长度差异
     * 时间：O（m+n）
     * 空间：O（1）
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
    /**
     * 哈希表
     * 时间：O(m+n)
     * 空间：O（m）
     */
//    public LeetCode.ListNode getIntersectionNode(LeetCode.ListNode headA, LeetCode.ListNode headB) {
//        HashSet<LeetCode.ListNode> setA = new HashSet<>();
//        LeetCode.ListNode curA = headA;
//        LeetCode.ListNode curB = headB;
//
//        while (curA != null){
//            setA.add(curA);
//            curA = curA.next;
//        }
//        while (curB != null){
//            if (setA.contains(curB)){
//                return curB;
//            }
//            curB = curB.next;
//        }
//        return null;
//    }

}

