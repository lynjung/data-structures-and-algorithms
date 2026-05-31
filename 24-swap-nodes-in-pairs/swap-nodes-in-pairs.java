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
    public ListNode swapPairs(ListNode head) {
        // edge case: linked list has 0 or 1 nodes
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ans = head.next; // new head when returning
        ListNode prev = null; // second node of the pair after swapping

        while (head != null && head.next != null) {
            
            if (prev != null) {
                prev.next = head.next; // connect prev pair to the rest of the list
            }

            prev = head; // save a pointer to connect with the rest of the list later

            ListNode nextNode = head.next.next; // make sure we can still access the rest of the list later
            head.next.next = head; // point second node to first node

            head.next = nextNode; // handle the case when there's an odd number of nodes which will be overriden in the next loop if there's not an odd number of nodes
            head = nextNode; // move to the next pair
        }
        return ans;
    }
}