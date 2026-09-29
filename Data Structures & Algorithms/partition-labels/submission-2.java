class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOccur = new int[26];
        List<Integer> res = new ArrayList<>();
        int size = 0, end = 0;

        for(int i = 0; i < s.length(); i++) lastOccur[s.charAt(i) - 'a'] = i;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            size++;
            end = Math.max(end, lastOccur[c - 'a']);
            if(i == end){
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
