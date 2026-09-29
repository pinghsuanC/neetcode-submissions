class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] p : prerequisites){
            indegrees[p[0]]++;
            adj.get(p[1]).add(p[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            res.add(cur);
            for(int nei : adj.get(cur)){
                if (--indegrees[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        int[] arr = new int[res.size()];
        if(res.size() != numCourses) return new int[]{};
        int count = 0;
        for(int c : res) arr[count++] = c;
        return arr;
    }
}
