package TwoPointer;

import utils.ListNode;

/**
 * @Author 车一晗
 * @Date 2022/06/15
 * 剑指Offer II 22
 **/
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != fast) {
                    ptr = ptr.next;
                    fast = fast.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
