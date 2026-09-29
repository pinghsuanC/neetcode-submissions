class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int taken = 0;

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] p : prerequisites){
            adj.get(p[1]).add(p[0]);
            indegrees[p[0]]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) {
                q.offer(i);
                taken++;
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nei : adj.get(cur)){
                indegrees[nei]--;
                if(indegrees[nei] == 0) {
                    taken++;
                    q.offer(nei);
                }
            }
        }

        return taken == numCourses;
    }
}
