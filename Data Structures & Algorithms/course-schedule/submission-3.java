class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // intuition: use kahn's alrogithm
        // create degree count array, adj map and a queue
        // push all the courses that doesn't need a prerequisite onto the queue
        // until quq is empty
            // pop a queue = take this course
            // decrement the devree count aray for each neighbours in adj map
            // if count = 0, then push it onto queue, course can be taken
        // loop through degree count, if anything > 0 return false.

        int n = numCourses;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        int[] counts = new int[n];
        
        for(int i = 0; i < n; i++) adj.putIfAbsent(i, new ArrayList<>());
        for(int[] edge : prerequisites){
            adj.get(edge[0]).add(edge[1]);
            counts[edge[1]]++;
        }
        for(int i = 0; i < counts.length; i++){
            if(counts[i] == 0) q.offer(i);
        }

        int finished = 0;
        while(!q.isEmpty()){
            int c = q.poll();
            finished++;
            for(int k : adj.get(c)){
                counts[k]--;
                if(counts[k] == 0) q.offer(k);
            }
        }

        return finished == numCourses;
    }
}





