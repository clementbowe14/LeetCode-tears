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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode res = new ListNode(0);
        add(p1, p2,res,0);
        res = res.next;
        return res; 
    }
    public void add(ListNode l1, ListNode l2, ListNode res,int current){
        if(l1 == null && l2 == null && current == 0){
            return;
        }
        if(l1 != null){
            current += l1.val;
            l1 = l1.next;
        }
        if(l2 != null){
            current += l2.val;
            l2 = l2.next;
        }
        ListNode temp = new ListNode(current % 10);
        res.next = temp;
        add(l1,l2,res.next,current/10);
    }
}