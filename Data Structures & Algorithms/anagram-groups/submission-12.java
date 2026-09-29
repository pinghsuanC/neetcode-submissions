class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // intuition: 
        // 1. There are only 26 possibilities. For anagrams, their frequencies are the same despite the orders differ.
        // 2. So the key is to extract the frequencies, and group them by frquencies
        // 3. Therefore, in a loop, find the frequency, condense it to string, and save to map. Use the frequency as a key in a map.

        Map<String, List<String>> freq = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String s : strs){
            int[] tab = new int[26];
            for(char c : s.toCharArray()) tab[c - 'a']++;
            String key = Arrays.toString(tab);
            freq.putIfAbsent(key, new ArrayList<String>());
            freq.get(key).add(s);
        }

        return freq.values().stream().collect(Collectors.toList());
    }
}
