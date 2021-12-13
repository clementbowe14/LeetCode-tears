class Solution {
    
    static class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public int findTheWinner(int n, int k) {
        if(n == 1) {
            return 1;
        }
        
        Node head = new Node(0);
        Node curr = head;
        
        for(int i = 1; i < n; i++) {
            Node nextNode = new Node(i);
            curr.next = nextNode;
            curr = curr.next;
        }
        
        curr.next = head;
        
        Node prev = null;
        curr = head;
        int rem = n;
        while(rem > 1) {
            
            int count = 1;
            while(count < k) {
                prev = curr;
                curr = curr.next;
                count++;
            }
            
            if(k < 2) {
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr = curr.next;
            }
            rem--;
        }
        
        return curr.data+1;
    }
}