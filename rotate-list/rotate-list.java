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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null){
            return head;
        }
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        curr = head; 
        int rotations = k % count;
        while(rotations > 0){
            ListNode p1 = null;
            ListNode p2 = curr;
            while(p2.next != null){
                p1 = p2;
                p2 = p2.next;
            }
            p1.next = p2.next;
            p2.next = curr;
            curr = p2;
            rotations--;
        }
        return curr;
    }
}