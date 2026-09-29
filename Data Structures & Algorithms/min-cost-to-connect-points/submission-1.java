class UnionFind{

    int[] parents;
    UnionFind(int n){
        parents = new int[n];
        for(int i = 0; i < n; i++) parents[i] = i;
    }

    int find(int i){
        if(parents[i] == i) return i;
        return find(parents[i]);
    }

    void union(int i, int j){
        int iRep = find(i);
        int jRep = find(j);
        parents[iRep] = jRep;        
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        // int[] a = [xi, yi, xj, yj, i, j],;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> 
            (Math.abs(a[0] - a[2]) + Math.abs(a[1] - a[3])) - (Math.abs(b[0] - b[2]) + Math.abs(b[1] - b[3])));
        boolean[] tracker = new boolean[points.length];
        UnionFind uf = new UnionFind(points.length);


        int cost = 0;
        for(int i = 0; i < points.length; i++){
            for(int j = i+1; j < points.length; j++){
                queue.offer(new int[]{points[i][0], points[i][1], points[j][0], points[j][1], i, j});
            }
        }

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int pairCost = Math.abs(pair[0] - pair[2]) + Math.abs(pair[1] - pair[3]);
            int i = pair[4], j = pair[5];

            // mark as connected
            if(uf.find(i) == uf.find(j)) continue;
            uf.union(i, j);
            // if not connected yet, add to cost
            cost += pairCost;
            
        }

        return cost;
    }
}
