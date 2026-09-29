class Solution {
    Map<Integer, List<Integer>> preMap ;
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        preMap = new HashMap<>();
        for(int[] req : prerequisites){
            preMap.putIfAbsent(req[1], new ArrayList<>());
            preMap.get(req[1]).add(req[0]);
        }

        for(int c = 0; c < numCourses; c++){
            if(!helper(c)) return false;
        }
        
        return true;
    }

    private boolean helper(int crs){
        if(visiting.contains(crs)) return false; // cycle detected
        if(!preMap.containsKey(crs) || preMap.get(crs).isEmpty()) return true;
        visiting.add(crs);
        for(int req : preMap.get(crs)){
            if(!helper(req)) return false;
        }
        visiting.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}
