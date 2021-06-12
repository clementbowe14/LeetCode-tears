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
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //now we reverse the back half of the LinkedList
        ListNode p1 = null; 
        fast = slow;
        while(fast != null){
            ListNode p3 = fast.next;
            fast.next = p1;
            p1 = fast;
            fast = p3;
        }
        
        //now we combine the lists together
        slow = head;
        while(p1 != null && slow != null){
            ListNode p3 = p1.next;
            p1.next = slow.next;
            slow.next = p1;
            p1 = p3;
            slow = slow.next.next;
        }
        if(slow != null){
            slow.next = null;
        }
        
    }
}