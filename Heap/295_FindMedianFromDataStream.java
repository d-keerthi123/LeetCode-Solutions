//Space Complexity O(n)

class MedianFinder {
    private PriorityQueue<Integer> leftMaxHeap;
    private PriorityQueue<Integer> rightMinHeap;

    public MedianFinder() {
      leftMaxHeap= new PriorityQueue<>
       (Collections.reverseOrder()); //descending order

       rightMinHeap=new PriorityQueue<>();

    }
    
    public void addNum(int num) { //O(log n)
        //add element to left max heap
        if(leftMaxHeap.isEmpty() || num<leftMaxHeap.peek()){
            leftMaxHeap.add(num);
        }
        else{
            rightMinHeap.add(num);
        }

        //Always maintain left max heap with 1 element more than the right_min_heap
        //or no. of elements should be equal in both heaps

        if(leftMaxHeap.size() > rightMinHeap.size()+1){
            // rightMinHeap.add(leftMaxHeap.peek());
            // leftMaxHeap.remove();

             rightMinHeap.add(leftMaxHeap.poll()); // poll() -->it removes element and returns in one step
        }
        //this case should never happen
        else if(leftMaxHeap.size() < rightMinHeap.size()){ 
            // leftMaxHeap.add(rightMinHeap.peek());
            // rightMinHeap.remove();
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() { O(1)
        // even
        if(leftMaxHeap.size() == rightMinHeap.size() ) {
            double mean= (leftMaxHeap.peek() + rightMinHeap.peek())/2.0;
            return mean;
        }

        return leftMaxHeap.peek();
    }
}
