//Time Complexity O(n log n)
//Space Complexity O(n)

class Solution {
    public class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;

        public Point(int x,int y,int distSq){
            this.x=x;
            this.y=y;
            this.distSq=distSq;
        }

        @Override
        public int compareTo(Point p2){
            //It automatically keeps smallest distance at top.
            return this.distSq-p2.distSq; //ascending order
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq=new PriorityQueue<>();

        for(int i=0;i<points.length;i++){
            int distSq=points[i][0]*points[i][0] + points[i][1]*points[i][1]; //x^2+ y^2
            pq.add(new Point(points[i][0],points[i][1],distSq));
        }
        //k rows  → number of points 
        //2 columns → x and y
        int result[][]=new int[k][2]; 

        //nearest points
        for(int i=0;i<k;i++){
            Point p=pq.remove();
            result[i][0]=p.x;
            result[i][1]=p.y;
        }
        return result;
    }
}
