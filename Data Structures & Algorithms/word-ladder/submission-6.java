class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Intuition: 
        // map, queue, list, visited list
        // build the following:
            // adjacent list
            // a map to index
        
        // Check if the wordlist has the end word
        // check if the wordlist has length

        // loop through the function to decide the adj list
            // use a function to check whether two words are a valid pair
        // mean while, keep track of list of words that are valid parents
            // use the same function between beginword and the outer loop

        // push valid parents to a queue, start with depth = 0
        // use BFS to find the min depth from the parents to the end word.
        // pull everything out of queue, loop through them
        // depth++
        // if found the word, return depth
        // if not, add to visited list
        // pull all its neighbours and push to queue.
        //return depth after queue empty.

        if(beginWord.equals(endWord) || !wordList.contains(endWord)) return 0;

        int depth = 0,
            n = wordList.size();
        Map<Integer, String> map = new HashMap<>();
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){ 
            adj.add(new ArrayList<>());
            map.put(i, wordList.get(i));
        }

        for(int i = 0; i < n; i++){
            if(arePairs(beginWord, map.get(i))) queue.offer(i);
            for(int j = i+1; j < n; j++){
                if(arePairs(wordList.get(i), wordList.get(j))){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        while(!queue.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            while(!queue.isEmpty()) arr.add(queue.poll());
            depth++;
            for(int i : arr){
                String s = map.get(i);
                if(s.equals(endWord)) return depth+1;
                visited[i] = true;
                for(int nei : adj.get(i)){
                    if(visited[nei]) continue;
                    queue.offer(nei);
                }
            }
        }

        return 0;
    }





    private boolean arePairs(String a, String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return true;
    }
}
