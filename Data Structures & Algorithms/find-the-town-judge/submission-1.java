class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] re : trust) adj.get(re[0]).add(re[1]);

        List<Integer> candidates = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(adj.get(i).isEmpty()) candidates.add(i);
        }

        for(int c : candidates){
            boolean ans = true;
            for(int i = 1; i < n+1; i++){
                if(i != c && !adj.get(i).contains(c)) ans = false;
            }
            if(ans) return c;
        }

        return -1;
    }
}