class Solution {
    class DSU{
        int[] parent;
        int[] rank;

        public DSU(int n){
            parent = new int[n + 1];
            rank = new int[n + 1];
            for(int i = 0; i <= n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        } 

        public int find(int i){
            if(parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public boolean union(int i, int j){
            int intI = find(i);
            int intJ = find(j);
            if(intI == intJ) return false;
            if(rank[intI] < rank[intJ]){
                int tmp = intI;
                intI = intJ;
                intJ = tmp;
            }

            parent[intJ] = intI;
            rank[intI] += rank[intJ];
            return true;
        }


    }
    
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;

        DSU dsu = new DSU(n);
        int comp = n;
        for(int[] edge : edges){
            if(!dsu.union(edge[0], edge[1])){
                return false;
            }
            comp--;
        }

        return comp == 1;
    }


}
