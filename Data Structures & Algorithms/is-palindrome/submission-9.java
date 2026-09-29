class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() <= 1) return true;
        StringBuilder newStr = new StringBuilder();
        for(char c : s.toCharArray()){
            if(!Character.isLetterOrDigit(c)) continue;
            newStr.append(Character.toLowerCase(c));
        }


        return newStr.toString().equals(newStr.reverse().toString());
    }
}
