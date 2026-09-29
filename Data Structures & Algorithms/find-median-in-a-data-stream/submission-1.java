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
        if(maxHeap.isEmpty()){
            maxHeap.offer(num);
            return;
        }
        if(num < maxHeap.peek()){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            while(!minHeap.isEmpty() && maxHeap.size() < counter/2+1){
                maxHeap.offer(minHeap.poll());
            }
        } else {
            minHeap.offer(num);
            while(!minHeap.isEmpty() && maxHeap.size() < counter / 2 + 1){
                maxHeap.offer(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if(counter == 1){
            int ele = maxHeap.poll();
            maxHeap.offer(ele);
            return ele;
        }
        if(isOdd()){
            int ele1 = maxHeap.poll();
            int ele2 = maxHeap.poll();
            maxHeap.offer(ele1);
            maxHeap.offer(ele2);
            return ele1;
        } 

        System.out.println(maxHeap);

        int ele1 = maxHeap.poll();
        int ele2 = maxHeap.poll();
        maxHeap.offer(ele1);
        maxHeap.offer(ele2);

        return (double)(ele1 + ele2) / 2;
    }

    private boolean isOdd(){
        return counter%2 == 1;
    }
}
