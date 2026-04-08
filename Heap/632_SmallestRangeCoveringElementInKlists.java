//Approach 1:
//Time Complexity O(n * k)
//Space Complexity O(k)

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
         int k=nums.size(); 

        //stores current idx of each list
        int ptr[]=new int[k]; //initially  [0, 0, 0, ..., 0]

        int resultRange[]={-1000000,1000000};
        while(true){
            int minEl=Integer.MAX_VALUE;
            int maxEl=Integer.MIN_VALUE;
            int minElListIdx = 0;

            //find current min and max among selected elements
            for(int i=0;i<k;i++){
                int listIdx=i;
                int elIdx=ptr[i];
                int element=nums.get(listIdx).get(elIdx);

                if(element < minEl){
                    minEl=element;
                    minElListIdx=listIdx;
                }
                maxEl=Math.max(maxEl,element);
            }
            //update range
            if (maxEl - minEl < resultRange[1] - resultRange[0] ||
            (maxEl - minEl ==     resultRange[1] - resultRange[0] && 
            minEl < resultRange[0])) {
                resultRange[0]=minEl;
                resultRange[1]=maxEl;
            }

            // Move pointer of list that had minimum element
            ptr[minElListIdx]++;
            // If that list is exhausted, stop
            if(ptr[minElListIdx] == nums.get(minElListIdx).size()){
                break;
            }

        }
        return resultRange;
    }
}
    


//Approach 2: Heap Approach
//Time Complexity O(n log k)
//Space Complexity O(k)

class Solution {
    public class Node implements Comparable<Node>{
        int val;
        int listIdx;
        int elementIdx;

        public Node(int val,int listIdx,int elementIdx){
            this.val=val;
            this.listIdx=listIdx;
            this.elementIdx=elementIdx;
        }

        @Override
        public int compareTo(Node l1){
            return this.val-l1.val;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {

        int k=nums.size();
        PriorityQueue<Node> pq= new PriorityQueue<>();

        int maxEl=Integer.MIN_VALUE;
        // add the first element of the list
        for(int i=0;i<k;i++){
            int value=nums.get(i).get(0);
            pq.add(new Node(value ,i,0));
            maxEl=Math.max(maxEl,value);
        }

        int rangeStart=-1000000;
        int rangeEnd=1000000;

        while(!pq.isEmpty()){
            Node curr=pq.remove();
            int minEl=curr.val;

            //update range
            if(maxEl-minEl < rangeEnd-rangeStart){
                rangeStart=minEl;
                rangeEnd=maxEl;
            }

            int nextIdx=curr.elementIdx+1;

            //if the next element exists in same list
            if(nextIdx< nums.get(curr.listIdx).size()){
                int nextVal=nums.get(curr.listIdx).get(nextIdx);
                pq.add(new Node(nextVal,curr.listIdx,nextIdx));
                maxEl= Math.max(maxEl,nextVal);
            }else{
                 // If any list ends, stop
                break;
            }
        }
        return new int[]{rangeStart,rangeEnd};
    }
}
