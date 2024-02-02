package hot100;

import pojo.ListNode;

/**
 * 环形链表
 */

public class N141 {
    public boolean hasCycle(ListNode head){
        if (head.next==null)return false;
        ListNode slow;
        ListNode fast;
        slow=head;
        fast=head;
        while (slow!=null&&fast!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast)
                return true;
        }
        return false;
    }
}
