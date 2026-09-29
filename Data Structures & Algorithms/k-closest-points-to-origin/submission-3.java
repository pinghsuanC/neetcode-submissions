class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // approach: calculate distance, and store it with the coordinates in int[3]
        // dump them into maxheap with b[0] - a[0]
        // when adding, poll the largest one in distance if size exceeds k

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for(int[] pt : points){
            int dis = pt[0]*pt[0] + pt[1]*pt[1];
            heap.offer(new int[]{
                dis, pt[0], pt[1]
            });
            if(heap.size() > k) heap.poll();
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] ele = heap.poll();
            res[i] = new int[]{ele[1],ele[2]};
        }

        return res;
    }
}
