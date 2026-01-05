 //Time Complexity O(n)
 //Space Compplexity O(1)
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || left==right){
            return head;
        } 
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        //left node
        ListNode beforeLeft=dummy;
        for(int i=1;i<left;i++){
            beforeLeft=beforeLeft.next; 
        }
        ListNode leftNode=beforeLeft.next;
        //right node
        ListNode rightNode=leftNode;
        for(int i=left;i<right;i++){
            rightNode=rightNode.next;
        }
        
        //store rightnode value before reversal
        ListNode afterRight=rightNode.next;
        ListNode prev=null;
        ListNode curr=leftNode;

        while(curr != afterRight ){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        beforeLeft.next=prev;
        leftNode.next=curr;

        return dummy.next;
    }
}
