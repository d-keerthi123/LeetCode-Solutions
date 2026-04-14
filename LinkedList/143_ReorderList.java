class Solution {
    public ListNode mid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast != null && fast.next != null){
            slow=slow.next; //+1
            fast=fast.next.next; //+2
        }
        return slow; // mid node
    }
    public void reorderList(ListNode head) {
        //find mid node --> last node of 1st half
        ListNode midNode=mid(head);
        ListNode secondHead=midNode.next;
        midNode.next=null;

        //reverse 2nd half
        ListNode curr=secondHead;
        ListNode prev=null;
        ListNode next;

        while(curr != null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //merge alternatively
        ListNode rightHead=prev;
        ListNode leftHead=head;

        ListNode nextL,nextR;
        while(rightHead != null && leftHead!= null){
            nextL=leftHead.next; //store before removing the link
            leftHead.next=rightHead;
            nextR=rightHead.next;
            rightHead.next=nextL;

            //update
            rightHead=nextR;
            leftHead=nextL;
        }
       
    }
}
