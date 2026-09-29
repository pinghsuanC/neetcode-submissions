class MyHashSet {

    List<Integer> arr;

    public MyHashSet() {
        arr = new ArrayList<>();
    }
    
    public void add(int key) {
        if(arr.contains(key)) return;
        arr.add(key);
    }
    
    public void remove(int key) {
        if(!arr.contains(key)) return;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == key) {
                arr.remove(i);
                return;
            }
        }
    }
    
    public boolean contains(int key) {
        return arr.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */