class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] arr = new int[26];
        int i = 0;
        for(char c : order.toCharArray()){
            arr[c - 'a'] = i;
            i++;
        }

        int index = 0;
        for(int k = 0; k < words.length - 1; k++){
            String w1 = words[k], w2 = words[k + 1];
            int j = 0;
            for (; j < w1.length(); j++) {
                if (j == w2.length()) return false;
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (arr[w1.charAt(j) - 'a'] > arr[w2.charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
            }
        }

        return true;
    }
}