class TimeMap {
    Map<String, HashMap<Integer, String>> storage;
    public TimeMap() {
        storage = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        storage.putIfAbsent(key, new HashMap<Integer, String>());
        storage.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!storage.keySet().contains(key)) return "";
        HashMap<Integer, String> values = storage.getOrDefault(key, new HashMap<Integer, String>());
        ArrayList<Integer> timestamps = new ArrayList<>(values.keySet());
        Collections.sort(timestamps);
        int time = findTimestamp(timestamp, timestamps);
        if(time < 0) return "";
        return storage.get(key).getOrDefault(time, "");
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
