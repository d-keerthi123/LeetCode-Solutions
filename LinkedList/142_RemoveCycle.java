public class Solution {
    public ListNode detectCycle(ListNode head) {

        //detect cycle
        ListNode slow=head;
        ListNode fast=head;
        boolean cycle=false; //lets assume no cycle exists

        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(cycle==false){
            return null;
        }
        //find the node where cycle starts
        slow=head;
        while(slow !=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow; //last node
    }
}
