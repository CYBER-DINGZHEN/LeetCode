package hot100;

import pojo.ListNode;

public class N160 {
    public static void main(String[] args) {
        //4，1，8，4，5
        //5，6，1，8，4，5
        //4，1，8，4，5，5，6，1，8，4，5
        //5，6，1，8，4，5，4，1，8，4，5
    }

    public ListNode n160(ListNode headA, ListNode headB) {
        if (headB == null || headA == null) return null;
        //记录一下头节点的位置
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null)
                a = headB;
            else
                a = a.next;
            if (b == null)
                b = headA;
            else
                b = b.next;
        }
        return a;
    }
}

