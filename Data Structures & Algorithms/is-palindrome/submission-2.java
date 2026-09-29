class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            char cc = Character.toLowerCase(c);
            if(!(c >= '0' && c <= '9' || cc >= 'a' && cc <= 'z')){
                continue;
            }
            sb.append(cc);
        }
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        return str1.equals(str2);
    }
}
