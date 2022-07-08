package LinkedList.Q206;

import utils.ListNode;

/**
 * @Author 车一晗
 * @Date 2022/07/07
 **/
public class Reverse {
    public ListNode reverseList(ListNode head) {
        //链表没有元素或者只有一个元素
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
