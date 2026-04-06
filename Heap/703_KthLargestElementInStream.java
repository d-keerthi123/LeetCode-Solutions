//Space Complexity O(k) -> bcz we are not storing all elements (heap size=k)

class KthLargest {

    private PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) { //O(n log k)
        this.k=k;
        pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size() > k){ // remove smallest element 
                pq.remove();
            }
        }
    }
    
    public int add(int val) { //O(log k)
        pq.add(val);
        if(pq.size() > k){
            pq.remove();
        }
        return pq.peek();
    }
}
