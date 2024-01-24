package hot100;

import pojo.ListNode;

public class N206 {
    public static void main(String[] args) {
    }
    public ListNode n206_digui(ListNode head) {
        //如何用递归实现？
        //每次操作的都是pre和cur
        ListNode cur=head;
        ListNode pre=null;
        //递归外部启动初始化
        return digui(pre,cur);

    }
    public ListNode digui(ListNode pre,ListNode cur)
    {
        if(cur==null)return pre;
        ListNode temp=cur.next;
        cur.next=pre;
//        pre=cur;
//        cur=temp;递归的更新并不是手动指定，而是传参更新
        return digui(cur,temp);

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
