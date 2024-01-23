package hot100;

import pojo.ListNode;

public class N206 {
    public static void main(String[] args) {
    }
    public ListNode n206_digui(ListNode head) {
        //如何用递归实现？
        //递归实现一次后，应该完成一次反转，并移动链表指针
        //0->1->2<-3<-4 现在我想让2指向1，如何操作？
        //1.next.next=1
        ListNode newHead=n206_digui(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
    public ListNode n206_diedai(ListNode head){
        ListNode cur=head;//记录当前节点
        ListNode pre=null;
        while (cur!=null) {//停止条件是什么？
            ListNode next = cur.next;
            cur.next=pre;//进行反转操作
            //不能对next进行next.next=cur这个操作，因为next.next的对象就会丢失
            //每次实现cur掉头指向pre，然后移动指针更新pre与cur
            pre=cur;
            cur=next;//移动指针
            //上一个是什么？当前是什么？下一个是什么？
        }
        return pre;
    }
}
