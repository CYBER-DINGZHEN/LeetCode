package hot100;

import pojo.ListNode;

/*
*   合并两个有序链表
*   将两个升序链表合并为一个新的升序链表并返回。
*   新链表是通过拼接给定的两个链表的所有节点组成的。
*
* */
public class N21 {
    public ListNode mergeTwoLists(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else if (list1.val<= list2.val)
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
    }

    /**
     * 引入伪头节点： 由于初始状态合并链表中无节点，因此循环第一轮时无法将节点添加到合并链表中。
     * 解决方案：初始化一个辅助节点pre作为合并链表的伪头节点，将各节点添加至pre之后。
     */
    public ListNode mergeTwoLists2(ListNode list1,ListNode list2) {
        ListNode pre=new ListNode(0);
        ListNode res=pre;
        while (list1!=null&&list2!=null)
        {
            if (list1.val <= list2.val) {
                pre.next = list1;
                pre = pre.next;
                list1 = list1.next;
            }
            //if (list2.val <= list1.val)
            else {
                pre.next = list2;
                pre = pre.next;
                list2 = list2.next;
            }
        }
        return res.next;
    }
}

