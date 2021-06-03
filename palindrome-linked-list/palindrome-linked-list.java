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
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode curr = head;
        ListNode dummy = new ListNode(curr.val);
        ListNode holder = dummy;
        while(curr.next != null){
            ListNode p2 = new ListNode(curr.next.val);
            dummy.next = p2;
            dummy = dummy.next;
            curr = curr.next;
        }
        curr = head;
        dummy = holder;
        ListNode p1 = null;
        while(dummy != null){
            ListNode p3 = dummy.next;
            dummy.next = p1;
            p1 = dummy;
            dummy = p3;
        }
        

        
        while(p1 != null & curr != null){
            if(p1.val != curr.val){
                return false;
            }
            System.out.println(curr.val + " " + p1.val);
            curr = curr.next;
            p1 = p1.next;
        }
        return true; 
    }
}