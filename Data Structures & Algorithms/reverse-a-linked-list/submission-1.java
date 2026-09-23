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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
            ListNode nextTemp = current.next;// save: record where "next" points, before we lose it
            current.next = prev;// Reverse: flip the arrow to point backward
            prev = current;// advance prev
            current = nextTemp;//advance current
        }
        return prev;
    }
}
