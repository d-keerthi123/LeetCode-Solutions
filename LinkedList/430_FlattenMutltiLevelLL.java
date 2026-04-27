//Time Complexity O(n)
//Space Complexity O(n) - bcz of recursion stack

class Solution {
    public Node flatten(Node head) {
        Node curr=head;
       
        while( curr != null){ //if there is valid child
            Node next=curr.next;
            if(curr.child != null){
                
                Node childHead=flatten(curr.child);
                curr.next=childHead;
                childHead.prev=curr;
                curr.child=null;
            
            Node temp=childHead;
            while(temp.next != null){
                temp=temp.next;
            }
            temp.next=next; // forward connection
            if(next != null){
                next.prev=temp; //backward connection
                }
            }

            curr=curr.next;
        }
        return head;
    }
}
