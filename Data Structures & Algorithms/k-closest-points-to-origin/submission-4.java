class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // approach: calculate distance, and store it with the coordinates in int[3]
        // dump them into maxheap with b[0] - a[0]
        // when adding, poll the largest one in distance if size exceeds k

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1])
            );
        
        for(int[] pt : points){
            heap.offer(pt);
            if(heap.size() > k) heap.poll();
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            res[i] = heap.poll();
        }

        return res;
    }
}
