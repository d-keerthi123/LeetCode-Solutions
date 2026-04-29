//TC:O(n)
//SC:O(1)

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        //create 2 linked lists odd and even 
        ListNode odd=head;
        ListNode even=head.next;
        ListNode  evenhead=even; //store head of even bcz we might lose head of even list

        while(even != null && even.next != null){
            odd.next=even.next;
            even.next=even.next.next;

            odd=odd.next;
            even=even.next;
        }
        //attach odd and even list
        odd.next=evenhead;

        return head;
    }
}
