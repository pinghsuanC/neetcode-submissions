class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int[] pt : points){
            minHeap.offer(pt[0]*pt[0] + pt[1]*pt[1]);
            if(minHeap.size() > k) minHeap.poll();
        }

        int kth = minHeap.peek();
        System.out.println(kth);
        List<int[]> arr = new ArrayList<>();
        for(int[] pt : points){
            if(pt[0]*pt[0] + pt[1]*pt[1] <= kth){
                arr.add(pt);
            }
        }

        int[][] res = new int[arr.size()][];
        for(int i = 0; i < arr.size(); i++){
            res[i] = arr.get(i);
        }

        return res;
    }
}
