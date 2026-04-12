class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //calculate size
        int size=0;
        ListNode temp=head;
        while(temp != null){
            temp=temp.next;
            size++;
        }
        //delete Nth node
        //edge case :
        //You have to remove the very first node (head)
        if(n==size){
            head=head.next;
            return head;
        }
        ListNode prev=head;
        for(int i=1;i<(size-n) ;i++){
            prev=prev.next;
        }
        prev.next=prev.next.next;

        return head;
    }
}
