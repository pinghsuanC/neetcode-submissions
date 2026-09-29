class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        Map<String, Integer> counts = new HashMap<>();

        // encode the website for convenience
        ArrayList<String> set = new ArrayList<>(new HashSet<>(Arrays.asList(website)));
        Map<String, Integer> webMap = new HashMap<>();

        List<String> res = new ArrayList<>();
        Map<String, List<int[]>> map = new HashMap<>();

        // create the arrays of websites for each user
        for(int i = 0; i < username.length; i++){
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new int[]{timestamp[i], i});
        }
        
        // for each user, get all the websites and count occurences in the group of 3
        String max = "";
        int maxCount = 0;
        for(String key : map.keySet()){
            List<int[]> arr = map.get(key);
            arr.sort((a, b) -> a[0] - b[0]);
            for(int i = 0; i + 2 < arr.size(); i++){
                String code = "" + website[arr.get(i)[1]] + ";" + website[arr.get(i+1)[1]] + ";" + website[arr.get(i+2)[1]];
                counts.putIfAbsent(code, 0);
                counts.put(code, counts.get(code)+1);
                if(counts.get(code) > maxCount){
                    maxCount = counts.get(code);
                    max = code;
                }
                if(counts.get(code) == maxCount && code.compareTo(max) < 0){
                    maxCount = counts.get(code);
                    max = code;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(max.split(";")));
    }
}