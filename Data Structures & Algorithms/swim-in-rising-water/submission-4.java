class DSU{

    int[] parents;

    public DSU(int n){
        parents = new int[n];
        for(int i = 0; i < n; i++) parents[i] = i;
    }

    public int find(int i){
        if(parents[i] == i) return i;
        int parent = find(parents[parents[i]]);
        parents[i] = parent;
        return parent;
    }

    public void union(int i, int j){
        int pI = find(i);
        int pJ = find(j);
        parents[pI] = pJ;
        // todo: add sizes or ranks to make it more efficient
    }

    public boolean connected(int i, int j){
        return find(i) == find(j);
    }
}

int[][] directions = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        DSU dsu = new DSU (m*n);

        List<int[]> arr = new ArrayList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr.add(new int[]{grid[i][j], i, j});
            }
        }

        Collections.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        for(int[] item : arr){
            int t = item[0], r = item[1], c = item[2];
            for(int[] dir : directions){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if(grid[nr][nc] > t) continue;
                dsu.union(r*m+c, nr*m+nc);
            }
            if(dsu.connected(0, m*n - 1)) return t;
        }

        return m*n;
    }
}

















