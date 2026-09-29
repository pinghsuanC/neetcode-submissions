class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int taken = 0;

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] p : prerequisites){
            indegrees[p[0]]++;
            adj.get(p[1]).add(p[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                q.offer(i);
                res.add(i);
                taken++;
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nei : adj.get(cur)){
                indegrees[nei]--;
                if(indegrees[nei] == 0){
                    taken++;
                    q.offer(nei);
                    res.add(nei);
                }
            }
        }

        int[] arr = new int[res.size()];
        if(taken != numCourses) return new int[]{};
        int count = 0;
        for(int c : res) arr[count++] = c;
        return arr;
    }
}
