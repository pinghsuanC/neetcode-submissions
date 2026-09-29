class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }
        char[] chars = s.toCharArray();
        return helper(chars, 0, Integer.MIN_VALUE);
    }

    public int helper(char[] arr, int i, int max){
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        for(int j = i; j < arr.length; j++){
            if(map.containsKey(arr[j])) return helper(arr, map.get(arr[j]) + 1, Math.max(len, max));
            map.put(arr[j], j);
            len++;
        }
        max = Math.max(len, max);
        return max;
    }
}
