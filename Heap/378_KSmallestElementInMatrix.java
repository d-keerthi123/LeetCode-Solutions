//Time Complexity O(nm log(nm))
//Space Complexity O(nm)

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
            //ascending order
            return this.num- p2.num;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<matrix.length ;i++){
            for(int j=0;j<matrix[i].length;j++){
                pq.add(new Pair(matrix[i][j],i));
            }
        }
        //k smallest element 
        for(int i=1;i<k;i++){
            pq.remove();
        }

        return pq.peek().num;
    }
}
