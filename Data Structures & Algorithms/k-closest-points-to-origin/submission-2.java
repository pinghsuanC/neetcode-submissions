class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
        for(int[] pt : points){
            maxHeap.offer(pt);
            if(maxHeap.size() > k) maxHeap.poll();
        }

        int[][] res = new int[k][];
        int i = 0;
        while(maxHeap.size() > 0){
            res[i++] = maxHeap.poll();
        }

        return res;
    }
}
