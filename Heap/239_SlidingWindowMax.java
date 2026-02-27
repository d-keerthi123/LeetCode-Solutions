//Time Complexity O(n log n)
//Space Complexity O(n)

class Solution {
    public class Pair implements Comparable<Pair>{
        int num;
        int idx;
        public Pair(int num,int idx){
            this.num=num;
            this.idx=idx;
        }

        @Override
        public int compareTo(Pair p2){
            //descending order
            return p2.num- this.num;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();

        int result[]= new int[nums.length -k +1] ;
        //1st window
        for(int i=0;i<k;i++){
            pq.add(new Pair(nums[i],i));
        }
        result[0]=pq.peek().num;

        for(int i=k;i<nums.length;i++){
            while(pq.size()>0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new Pair(nums[i],i));
            result[i-k+1]=pq.peek().num;
        }
        return result;
    }
}
