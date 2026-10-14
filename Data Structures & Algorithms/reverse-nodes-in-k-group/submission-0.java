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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;
            ListNode prev = kth.next;
            ListNode current = groupPrev.next;
            while (current != groupNext) {
                ListNode nextTemp = current.next;
                current.next = prev;
                prev = current;
                current = nextTemp;
            }
            ListNode groupStart = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = groupStart;
        }
        return dummy.next;
    }
    private ListNode getKth(ListNode current, int k) {
        while (current != null && k > 0) {
            current = current.next;
            k--;
        }
        return current;
    }
}
