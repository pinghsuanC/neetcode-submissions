class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // intuition: build a undirectional map with 1 letter diff words as neighbours
        
        // special case -> check if wordList contains end or begin == end

        // -> helper function to decide if two words are a pair

        // -> after building the adj map, add all valid words with the begin word to a queue

        // -> do BFS to find the min depth
        //      
        //      can use the function to loop again, or replace one letter in the begin word

        if(beginWord == endWord || !wordList.contains(endWord)) return 0;
        Map<String, List<String>> adj = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        // save loop by getting the starting poitns at the same time
        for(int i = 0; i < wordList.size(); i++){
            String a = wordList.get(i);
            if(areNeighbours(a, beginWord)) q.offer(a);
            for(int j = i+1; j < wordList.size(); j++){
                String b = wordList.get(j);
                if(areNeighbours(a,b)){
                    adj.putIfAbsent(a, new ArrayList<>());
                    adj.putIfAbsent(b, new ArrayList<>());
                    adj.get(a).add(b);
                    adj.get(b).add(a);
                }
            }
        }

        // Do BFS
        int res = 1;
        while(!q.isEmpty()){
            res++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                String node = q.poll();
                visited.add(node);
                if(node.equals(endWord)) return res;
                if(!adj.containsKey(node)) continue;
                for(String nei : adj.get(node)){
                    if(!visited.contains(nei)){
                        visited.add(nei);
                        q.add(nei);
                    }
                }
            }
        }

        return 0;
    }

    private boolean areNeighbours(String a, String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return true;
    }
}
