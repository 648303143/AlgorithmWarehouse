package linkedlist;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author zhangqingyang
 * @date 2022-05-24-17:56
 * 链表的每个结点除了指向下一个还指向一个随机的结点
 * 复制一个这样的链表
 */
public class RandomLinkedlist {
    public static void main(String[] args) {
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        RandomListNode n1 = new RandomListNode(7);
        RandomListNode n2 = new RandomListNode(13);
        RandomListNode n3 = new RandomListNode(11);
        RandomListNode n4 = new RandomListNode(10);
        RandomListNode n5 = new RandomListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;
        RandomLinkedlist randomLinkedlist = new RandomLinkedlist();
        randomLinkedlist.copy02(n1);
    }
    /**
     * 使用额外空间的方法
     *
     * @param head
     * @return
     */
    public RandomListNode copy01(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            RandomListNode node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 不使用额外空间
     *
     * @param head
     * @return
     */
    public RandomListNode copy02(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode n = new RandomListNode(cur.val);
            n.next = cur.next;
            cur.next = n;

            cur = cur.next.next;
        }
        cur = head;
        while (cur != null ) {
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }
        RandomListNode res = head.next;
        cur = head;
        while (cur != null) {
            RandomListNode next = cur.next.next;
            RandomListNode copyCur = cur.next;
            cur.next = next;
            copyCur.next = next != null ? next.next : null;
            cur = cur.next;
        }
        return res;
    }
}


class RandomListNode {
    int val;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(int val, RandomListNode next, RandomListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    RandomListNode(int x) {
        val = x;
    }

    public RandomListNode() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomListNode listNode = (RandomListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}