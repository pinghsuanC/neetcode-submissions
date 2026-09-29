class Solution {
    int[] parentOf;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        // solution withou DFS: Union find / disjoint set
        // use union find DS to find the circle

        // initialize what're needed
        int n = edges.length;
        parentOf = new int[n+1];
        rank = new int[n+1];
        for(int i = 0; i < n+1; i++){
            parentOf[i] = i;
            rank[i] = 1;
        }

        for(int[] e : edges){
            int a = e[0], b = e[1];
            if(!union(a, b)) return e;
        }

        return new int[]{};
    }

    // function to find the parent + compress the path
    private int findParent(int node){
        int root = parentOf[node];
        if(root != node){
            parentOf[node] = findParent(root);
            return parentOf[node];
        }
        return root;
    }

    // function to union i and j with rank
    private boolean union(int i, int j){
        int pI = findParent(i);
        int pJ = findParent(j);
        if(pI == pJ) return false;
        if(rank[pI] == rank[pJ]){
            // doesn't care, just merge them
            parentOf[pI] = pJ;
            // increment rank of j
            rank[pJ]++;
        } else if (rank[pI] < rank[pJ]){
            parentOf[pI] = pJ;
        } else {
            parentOf[pJ] = pI;
        }
        return true;
    }
}







