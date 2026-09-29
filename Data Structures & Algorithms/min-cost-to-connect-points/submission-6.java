class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, cost = 0;
        // int[] => [cost, node]
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{0, 0});

        while(visited.size() < n && !queue.isEmpty()){
            int[] cur = queue.poll();
            if(visited.contains(cur[1])) continue;
            
            visited.add(cur[1]);
            cost+=cur[0];

            for(int i = 0; i < n; i++){
                if(i == cur[1]) continue;
                if(visited.contains(i)) continue;
                queue.offer(new int[]{getCost(points[cur[1]], points[i]), i});
            }
        }

        return cost;
    }

    public int getCost(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
