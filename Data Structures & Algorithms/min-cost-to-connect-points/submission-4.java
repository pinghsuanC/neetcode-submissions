class UnionFind{

    int[] parents;
    public UnionFind(int n){
        // initialize each parent to their own
        parents = new int[n];
        for(int i = 0; i < n; i++) parents[i] = i;
    }

    public int find(int i){
        if(parents[i] == i) return i;
        int parent = find(parents[i]);
        parents[i] = parent;
        return parent;
    }

    public void union(int i, int j){
        // for this question's purpose, just gonna join them without rankings / sizing checks
        int parentI = find(i);
        int parentJ = find(j);
        parents[parentI] = parentJ;
    }

}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, cost = 0;

        // int[] => [DIST(I, J), i, j]
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // tracks if two points are in the same component already
        UnionFind uf = new UnionFind(n);

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                q.offer(new int[]{getCost(points[i][0], points[i][1], points[j][0], points[j][1]), i, j});
            }
        }

        while(!q.isEmpty()){
            int[] a = q.poll();
            if(uf.find(a[1]) == uf.find(a[2])) continue; // already connected
            uf.union(a[1], a[2]);
            cost += a[0];
        }
        
        return cost;
    }

    public int getCost(int x0, int y0, int x1, int y1){
        return Math.abs(x0 - x1) + Math.abs(y0 - y1);
    }
}
