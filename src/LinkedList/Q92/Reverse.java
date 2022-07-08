package LinkedList.Q92;

import utils.ListNode;

/**
 * @Author 车一晗
 * @Date 2022/07/07
 **/
public class Reverse {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //base case
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    //后驱节点
    ListNode successor = null;
    //反转以head为起点的n个节点，返回新的头节点
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            //记录第n+1个节点
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
