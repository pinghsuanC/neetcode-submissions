class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] latest = new int[26];
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) latest[s.charAt(i) - 'a'] = i;

        int res = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            res++;
            end = Math.max(end, latest[s.charAt(i) - 'a']);
            if(end == i){
                arr.add(res);
                res = 0;
            }   
        }

        return arr;
    }
}
