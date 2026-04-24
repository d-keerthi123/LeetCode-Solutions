//TC: O(n) Each node is visited once (reversing + recursion traversal)
//SC: O(n) bcz of the call stack in the worst case scenario

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if( head.next == null){
            return head;
        }
        //check if k nodes exist
        ListNode temp=head;
        int count=0;
        while(count <k){
            if(temp == null){
                return head;
            }
            temp=temp.next;
            count++;
        }
        
        ListNode prev=reverseKGroup(temp,k);

        temp=head;
        count=0;
        while(count <k){
            ListNode next=temp.next;
            temp.next=prev;
            //update
            prev=temp;
            temp=next;

            count++;
        }

        return prev;
    }
}
