class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> adj = new ArrayList<>();
        Map<Integer, List<Integer>> adj2 = new HashMap<>();

        for(int i = 0; i <= n; i++) adj.add(new ArrayList<Integer>());

        List<Integer> candidates = new ArrayList<>();
        for(int[] t : trust) {
            adj.get(t[1]).add(t[0]);

            adj2.putIfAbsent(t[0], new ArrayList<>());
            adj2.get(t[0]).add(t[1]);
            
            if(adj.get(t[1]).size() == n - 1) candidates.add(t[1]);
        }

        for(int c : candidates){
            if(!adj2.containsKey(c)) return c;
        }


        return -1;
    }
}