class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOcc = new int[26];
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) lastOcc[s.charAt(i) - 'a'] = i;

        int end = 0, len = 0;
        for(int i = 0; i < s.length(); i++){
            len++;
            end = Math.max(end, lastOcc[s.charAt(i) - 'a']);
            if(end == i){
                res.add(len);
                len = 0;
            }
        }

        return res;
    }
}
