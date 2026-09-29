class Solution {
    public boolean checkInclusion(String s1, String s2) {
        List<Character> arr = s1.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.toList());
        Set<Character> set = new HashSet<>(arr);
        Collections.sort(arr);
        String target = arr.toString();
        
        for(int i = 0; i<s2.length(); i++){
            if(!set.contains(s2.charAt(i))){
                continue;
            }
            List<Character> arr2 = new ArrayList<>();
            int l = i;
            while(l - i < s1.length() && l < s2.length()){
                arr2.add(s2.charAt(l));
                l++;
            }
            Collections.sort(arr2);
            
            if(target.equals(arr2.toString())){
                return true;
            }
        }

        return false;
    }
}
