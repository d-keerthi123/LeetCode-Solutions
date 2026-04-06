//Time Complexity O(n log n)
//Space Complexity O(n)

class Solution {
    public class Pair implements Comparable<Pair>{
        int num;
        int idx;

        Pair(int num,int idx){
            this.num=num;
            this.idx=idx;
        }
        @Override
        public int compareTo(Pair p2){
            //desc order --> max heap
            return p2.num-this.num;
        }
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
        }

        // kth largest
        for(int x=1;x<k;x++){
            pq.remove();
        }
        return pq.peek().num;
    }
}  


//More efficient Approach
//Space  Complexity O(k)--> bcz heap size is K
// Time Complexity O(n log k) 

class Solution {
    public class Pair implements Comparable<Pair>{
        int num;
        int idx;

        Pair(int num,int idx){
            this.num=num;
            this.idx=idx;
        }
        @Override
        public int compareTo(Pair p2){
            return this.num-p2.num;
        }
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
            if(pq.size() >k ){
                pq.remove();
            }
        }
        return pq.peek().num;
    }
}
