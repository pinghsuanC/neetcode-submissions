class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->
            (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1])
        );

        for(int i = 0; i < points.length; i++){
            pq.offer(points[i]);
            if(pq.size() > k) pq.poll();
        }

        int[][] res = new int[k][];
        int count = 0;
        while(!pq.isEmpty()){
            res[count] = pq.poll();
            count++;
        }

        return res;
    }
}
