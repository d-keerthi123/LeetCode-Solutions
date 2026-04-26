//Time Complexity O(n)
//Space Complexity O(1)

class Solution {
    public ListNode findNthNode(ListNode temp,int k){
        int count=1;
        while(temp != null){
            if(count ==k ){
                return temp;
            }
            count++;
            temp=temp.next;
        }
        
            return temp;

    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0){
            return head;
        }
        int len=1;
        ListNode tail=head;
        while(tail.next != null){
            len++;
            tail=tail.next;
        }
        if(k % len==0){
            return head;
        }
        k=k % len;
        tail.next=head;
        ListNode newLastNode=findNthNode(head,len-k);
        head=newLastNode.next;
        newLastNode.next=null;

        return head;

    }
}
===========================================================================================================================================================

//Approach 2
//TC: O(n) 
//SC: O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      if(head == null || head.next==null){
        return head;
      }
      //size of ll  O(n)
      int size=1;
      ListNode tail=head;
      while(tail.next != null){
        tail=tail.next;//last node
        size++;
      }

      //Find k(rotations)
      k = k % size;

      if(k==0){
        return head; //no change ,returns same ll
      }
      //1->2->3->4->5
      ListNode curr=head;
      for(int i=1;i<size-k;i++){  //O(n)
        curr=curr.next; //1->2->3
      }
      ListNode newHead=curr.next; //4
      curr.next=null; // breaks after 3  : 1->2->3->null  4->5->null
      tail.next=head;  // 5 → 1 
      return newHead; //4->5->1->2->3->mull
    }
}
