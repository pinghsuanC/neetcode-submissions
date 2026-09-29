class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Using a kahn's algorithm, it's guaranteed that the next best available is taken
        // So apply the kahn's algorithm, and when polling from queue, add it to a list.
        // at the end, if the finished == numCourses, return the list
        // else return empty set

        int[] indegrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] req : prerequisites){
            indegrees[req[0]]++;
            adj.get(req[1]).add(req[0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){ 
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int c : adj.get(node)){
                indegrees[c]--;
                if(indegrees[c] == 0){
                    q.offer(c);
                }
            }
        }

        if(res.size() == numCourses){
            int[] r = new int[res.size()];
            for(int i = 0; i < res.size(); i++){
                r[i] = res.get(i);
            }
            return r;
        }
        return new int[]{};
    }
}







