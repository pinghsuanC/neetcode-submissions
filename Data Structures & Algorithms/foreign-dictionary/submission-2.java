class Solution {
    public String foreignDictionary(String[] words) {
        if(words.length == 0) return "";

        Map<Character, Set<Character>> adj = new HashMap<>();
        int[] indegree = new int[26];
        boolean[] exists = new boolean[26];

        for(String word : words){
            for(char c : word.toCharArray()){
                adj.putIfAbsent(c, new HashSet<>());
                exists[c - 'a'] = true;
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i], w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() && w1.indexOf(w2) == 0) return "";

            for(int j = 0; j < minLen; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    if (!adj.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree[w2.charAt(j) - 'a']++;
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < 26; i++){
            if(indegree[i] == 0 && exists[i]) q.offer((char)(i + 'a'));
        }

        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            char char_ = q.poll();
            res.append(char_);
            for(char nei : adj.get(char_)){
                indegree[nei - 'a']--;
                if(indegree[nei - 'a'] == 0) q.offer(nei);
            }
        }

        int counter = 0;
        for(boolean e : exists){
            if(e) counter++;
        }

        if(res.length() != counter) return "";

        return res.toString();
    }
}
