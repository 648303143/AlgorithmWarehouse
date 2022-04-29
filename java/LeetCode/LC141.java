package LeetCode;

/**
 * @author zhangqingyang02
 * @date 2022-04-06-19:37
 */

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示
 * 链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 */
public class LC141 {
}

// 方法一：hash表
//时间复杂度 空间复杂度 O（n）
//class LeetCode.Solution141 {
//    public boolean hasCycle(LeetCode.ListNode head) {
//        HashSet<LeetCode.ListNode> set = new HashSet<>();
//        LeetCode.ListNode cur = head;
//        while (cur != null){
//            if (set.contains(cur)){
//                return true;
//            }
//            set.add(cur);
//            cur = cur.next;
//        }
//        return false;
//    }
//}

/**
 * 方法二 ：快慢指针
 * 时间复杂度 O（n）
 * 空间复杂度 O（1）
 */
class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                return true;
            }
        }
        return false;
    }
}
