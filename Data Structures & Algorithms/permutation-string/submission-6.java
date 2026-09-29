class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] code = new int[26];
        Set<Character> set = new HashSet<>();
        int len = s1.length();
        for(int i = 0; i<len; i++){
            code[s1.charAt(i) - 'a']++;
            set.add(s1.charAt(i));
        }
        String target = Arrays.toString(code);

        for(int l = 0; l+len - 1<s2.length(); l++){
            int start = l;
            int end = start + len;
            if(!set.contains(s2.charAt(start))){
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
