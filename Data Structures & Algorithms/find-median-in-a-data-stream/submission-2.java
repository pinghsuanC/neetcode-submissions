class MedianFinder {
    // approach: 1 heap tracks median at n/2 and n/2+1 position
    // 1 minheap tracks next minimun
    // counter tracks total # of elements

    // when addNum, 2 cases
    // 1. when num < maxHeap.peek(), meaning remove max from maxheap
    // 2. when num >= maxheap.peek(), meaning add to minheap, get next mininum

    // when find median, check odd/even and calculate from heap poll()
    // after that offer them back to heap
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int counter;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
        counter = 0;
    }
    
    public void addNum(int num) {
        counter++;
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        } else if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(isOdd()){
            return maxHeap.peek();
        }

        return (double)(maxHeap.peek() + minHeap.peek()) / 2;
    }

    private boolean isOdd(){
        return counter%2 == 1;
    }
}
