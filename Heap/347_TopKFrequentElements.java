//Time Complexity O(n logn)
//Space Complexity O(n)

class Solution {
    public class Pair implements Comparable<Pair>{
        int num;
        int freq;

        public Pair(int num,int freq){
            this.num=num;
            this.freq=freq;
        }

        @Override
        public int compareTo(Pair p2){
            return p2.freq-this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int i=0;
        while(i<nums.length){
            int count=1;
            int current=nums[i];
            int j=i+1;
            while(j<nums.length && nums[j]== current){
                count++;
                j++;
            }
            pq.add(new Pair(current,count));
            i=j;
        }

        // top k frequent elements
        int result[]= new int[k];
        for(int x =0;x <k;x++){
            result[x]=pq.remove().num;
        }

        return result;
    }
}
