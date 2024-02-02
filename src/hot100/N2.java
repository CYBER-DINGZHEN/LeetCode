package hot100;
import pojo.ListNode;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.time.Period;

/*
 *      链表两数相加
 *      4  6  5
 *      3  8  4
 *      7  4  0  1
 *      对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点 head。
 *      使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
 */
public class N2 {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        if(l1==null||l2==null)return l1==null?l2:l1;
        int sum;//用于计算两个节点val相加
        int jinwei = 0;//表示进位
        int temp = 0;
        ListNode pre=new ListNode(0);
        ListNode res=pre;
        while (l1!=null||l2!=null) {
            int l1sum=l1==null?0:l1.val;
            int l2sum=l2==null?0:l2.val;
            sum=l1sum+l2sum+jinwei;

            temp=sum%10;//保存该位;
            jinwei=sum/10;//进位，取值为0/1;
            ListNode move=new ListNode(temp);
            pre.next=move;
            pre=pre.next;

            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if (jinwei==1){
            ListNode last=new ListNode(1);
            pre.next=last;
        }
        return res.next;
    }




    }

