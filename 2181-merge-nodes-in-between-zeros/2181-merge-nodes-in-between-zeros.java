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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode iter = dummy;
        ListNode curr = head.next;
        int currentSum = 0;
        
        while(curr != null) {
            if(curr.val != 0) {
                currentSum += curr.val;
            } else {
                iter.next = new ListNode(currentSum);
                iter = iter.next;
                currentSum = 0;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}