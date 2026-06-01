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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
    
        ListNode dummy = new ListNode(0); // create a fake node before the head
        dummy.next = head;

        ListNode beforeReverse = dummy;

        for (int i = 1; i < left; i++) {
            beforeReverse = beforeReverse.next; // stop at the node before section we want to reverse
        }

        ListNode prev = null;
        ListNode curr = beforeReverse.next; // start node of the section we want to reverse

        for (int i = 0; i < right - left + 1; i++) { // reverse 'right - left + 1' many nodes -> # of nodes in the section we want to reverse
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // after reversing, prev -> head of the reversed section
        // curr -> node after the reversed section

        beforeReverse.next.next = curr; // connect the now tail of the reversed section to the rest of the list
        beforeReverse.next = prev; // connect the part before reversal to new head of the reversed section

        return dummy.next;
    }
}