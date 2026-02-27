// m- rows : n- col
//Time Complexity O(m × n + m log m)
// counting no of 1's in each step O(mx n), inserting m rows O(m log m ) ,
// removing k elements O( k log m )
//Space Comlexity O(m) we store :Priority queue of size m  & Result array of size k

class Solution {
    public class Rows implements Comparable<Rows>{
        int rows;
        int idx;

        public Rows(int rows,int idx){
            this.rows=rows;
            this.idx=idx;
        }

        @Override
        public int compareTo(Rows r2){
            if(this.rows == r2.rows) {
                return this.idx- r2.idx;
            }
            else{
                return this.rows- r2.rows;
            }
        }

    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Rows> pq= new PriorityQueue<>();

        for(int i=0;i<mat.length;i++){ //rows
            int count=0;
            for(int j=0;j<mat[i].length;j++){ //columns
                count+= mat[i][j] ==1 ? 1: 0;
            }
            pq.add(new Rows(count,i));
        }
        // k weak rows
        int result[] =new int[k];
        for(int i=0;i<k;i++){
            result[i]=pq.remove().idx;
        }
        return result;
    }
}
