/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (secondHalf != null) {
            ListNode tmp = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = tmp;
        }
        ListNode p1 = head;
        ListNode p2 = prev;
        while (p2 != null) {
            ListNode P1Next = p1.next;
            ListNode P2Next = p2.next;
            p1.next = p2;
            p2.next = P1Next;
            p1 = P1Next;
            p2 = P2Next;
        }
    }
}
