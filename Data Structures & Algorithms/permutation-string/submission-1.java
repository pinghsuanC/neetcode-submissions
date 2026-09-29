class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] code = new int[26];
        int len = s1.length();
        for(int i = 0; i<len; i++){
            code[s1.charAt(i) - 'a']++;
        }
        String target = Arrays.toString(code);

        for(int l = 0; l<s2.length(); l++){
            int start = l;
            int end = start + len;
            if(end - 1 >= s2.length() || start >= s2.length()){
                return false;
            }
            if(!(code[s2.charAt(start) - 'a'] > 0 && code[s2.charAt(end - 1) - 'a'] > 0)){
                continue;
            }
            int[] code2 = new int[26];
            while(start < end){
                code2[s2.charAt(start) - 'a']++;
                start++;
            }
            if(target.equals(Arrays.toString(code2))){
                return true;
            }
        }

        return false;
    }
}
