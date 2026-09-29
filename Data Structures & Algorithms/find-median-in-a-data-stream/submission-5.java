class MedianFinder {
    // median: odd: n/2+1, even: (n/2 + (n/2+1)) / 2
    // min-heap / max-heap
    // smaller half m -> max-heap
    // larger half k -> min-heap

    PriorityQueue<Integer> lower;
    PriorityQueue<Integer> higher;


    public MedianFinder() {
        lower = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a)); // max heap
        higher = new  PriorityQueue<Integer>(); // minheap
    }
    
    public void addNum(int num) {
        lower.offer(num);

        // rebalance two piles
        while(lower.size() > higher.size()){
            higher.offer(lower.poll());
        }
        while(higher.size() > lower.size()){
            lower.offer(higher.poll());
        }        
    }
    
    public double findMedian() {
        if(lower.isEmpty()) return higher.peek();
        if(higher.isEmpty()) return lower.peek();

        if((lower.size() + higher.size()) % 2 == 0){
            return ((double)lower.peek() + higher.peek()) / 2;
        } else {
            return lower.peek();
        }

    }
}
