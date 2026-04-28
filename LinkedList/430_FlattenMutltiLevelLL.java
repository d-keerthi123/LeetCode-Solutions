//Time Complexity O(n)
//Space Complexity O(n) - bcz of recursion stack

class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        Node curr=head;
        while(curr != null){
            Node next=curr.next;
            //valid child node
            if(curr.child != null){
                curr.next=flatten(curr.child);
                curr.next.prev=curr;
                curr.child=null;
            //Find tail
            while(curr.next != null){
               curr=curr.next;
            }
            //Attach tail with next 
            if(next != null){
                curr.next=next;
                next.prev=curr;
            }
            }
            curr=curr.next;
        }
        return head;
    }
}
