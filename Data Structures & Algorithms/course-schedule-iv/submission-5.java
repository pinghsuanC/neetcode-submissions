class Solution {

    /*
    intuition
    have 2 maps
    courseDependency -> [list of courses that depends on the prerequest]
    prerequestsByCourse -> [list of prerequests]

    also the recording of the degrees
    int[] indegree = # prerequests one course needs

    the key is to build the second map as one goes through the prerequestes
    bag everything that has 0 degrees, create a list with these degrees
    take the course -> decrese the degree of all its dependencies i in the first map. 
    if the indegree is 0, then it means course i needs the parent's prerequeset + parent up until to this point
    */

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();

        List<Set<Integer>> courseDependency = new ArrayList<>();
        List<Set<Integer>> prerequestsByCourse = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // initialize
        for(int i = 0; i < numCourses; i++) {
            courseDependency.add(new HashSet<Integer>());
            prerequestsByCourse.add(new HashSet<Integer>());
        }

        // populate neighbour maps
        for(int[] pre : prerequisites){
            int a = pre[0], b = pre[1];
            courseDependency.get(a).add(b); // course b depends on a
            prerequestsByCourse.get(b).add(a); // b's list of requirements
            indegree[b]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(prerequestsByCourse.get(i).size() == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll(); // course dependency = 0
            for(int nei : courseDependency.get(cur)){   // take the course and check if any more valid courses are open for taking
                prerequestsByCourse.get(nei).addAll(prerequestsByCourse.get(cur));  // may need to change the syntax but basically dump the prerequests into the res
                indegree[nei]--;
                if(indegree[nei] == 0){
                    queue.offer(nei);
                }
            }
        }

        for(int[] query : queries){
            int u = query[0], v = query[1];
            ans.add(prerequestsByCourse.get(v).contains(u));
        }

        return ans;
    }
}