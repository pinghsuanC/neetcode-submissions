class TimeMap {
    Map<Integer, Map<String, String>> storage;
    Map<String, ArrayList<Integer>> keys;
    public TimeMap() {
        storage = new HashMap<>();
        keys = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        storage.putIfAbsent(timestamp, new HashMap<String, String>());
        storage.get(timestamp).put(key, value);
        keys.putIfAbsent(key, new ArrayList<>());
        keys.get(key).add(timestamp);
        System.out.println(storage);
        System.out.println();
    }
    
    public String get(String key, int timestamp) {
        if(!keys.keySet().contains(key)) return "";
        ArrayList<Integer> timestamps = keys.getOrDefault(key, new ArrayList<>());
        Collections.sort(timestamps);
        int time = findTimestamp(timestamp, timestamps);
        System.out.println("storage cur:" + storage);
        System.out.println("finding:" + timestamp + " " + key + " result: " + time);
        if(time < 0) return "";
        return storage.get(time).getOrDefault(key, "");
    }

    private int findTimestamp(int target, ArrayList<Integer> values){
        if(values.size() == 0) return -1;
        int max = -1, l = 0, r = values.size() - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(values.get(m) == target) return target;
            if(values.get(m) > target){
                r = m -1;
            } else {
                max = Math.max(max, values.get(m));
                l = m + 1;
            }
        }
        return max;
    }
}
