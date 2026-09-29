class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] code = new int[26];
        int len = s1.length();
        for(int i = 0; i<len; i++){
            code[s1.charAt(i) - 'a']++;
        }
        String target = Arrays.toString(code);

        for(int l = 0; l<s2.length(); l++){
            int k = 0;
            int[] code2 = new int[26];
            while(k < len && (l + k) < s2.length()){
                code2[s2.charAt(l + k) - 'a']++;
                k++;
            }
            if(target.equals(Arrays.toString(code2))){
                return true;
            }
        }

        return false;
    }
}
