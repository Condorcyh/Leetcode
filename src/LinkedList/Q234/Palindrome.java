package LinkedList.Q234;

import utils.ListNode;

/**
 * @Author 车一晗
 * @Date 2022/06/27
 **/
public class Palindrome {

    public boolean isPalindrome(ListNode head) {
        //快慢指针找到中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表长度有奇偶
        if (fast != null) {
            slow = slow.next;
        }
        //从slow开始反转列表
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
