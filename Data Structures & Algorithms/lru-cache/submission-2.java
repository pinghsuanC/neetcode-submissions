class ListNode{
    Integer value;
    Integer key;
    ListNode next;
    ListNode prev;

    ListNode(int key, int value){
        this.value = value;
        this.key = key;
        next = null;
        prev = null;
    }

    ListNode(){
        key = null;
        value = null;
        next = null;
        prev = null;
    }

    public void set(int key, int value){
        // update key value pairs
        this.key = key;
        this.value = value;
    }
}



class LRUCache {

    // [dummyHead] -> [listHead] ->...-> [dummyTail]

    ListNode dummyHead;
    ListNode dummyTail;
    ListNode end;
    Map<Integer, ListNode> finder;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead = new ListNode();
        dummyTail = new ListNode();
        finder = new HashMap<>();

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

    }
  

    public int get(int key) {
        if(!finder.containsKey(key)) return -1;

        ListNode target = finder.get(key);
        // remove target and append to the end
        remove(target);
        addToTail(target);
        return target.value;
    }

    public void put(int key, int value) {
       // cache is empty
       if(finder.size() == 0){
        ListNode node = new ListNode(key, value);
        addToTail(node);
        finder.put(key, node);
        return;
       }

       // found the key
       if(finder.containsKey(key)){
            ListNode node = finder.get(key);
            node.value = value;
            remove(node);
            addToTail(node);
            return;
       }

       // has the capacity
       if(finder.size() < capacity){
            ListNode node = new ListNode(key, value);
            addToTail(node);
            finder.put(key, node);
            return;
       }

       // doesn't have capacity, didn't find it in map, so remove the head & key and create a new node
       ListNode head = dummyHead.next;
       remove(head);
       finder.remove(head.key);
       ListNode node = new ListNode(key, value);
       addToTail(node);
       finder.put(key, node);
    }

    public void remove(ListNode node){
        if(node == null) return;
        // detach the node from prev and next

        ListNode prev = node.prev;
        ListNode next = node.next;

        if(prev != null) prev.next = next;
        if(next != null) next.prev = prev;
    }

    public void addToTail(ListNode node) {
        ListNode prev = dummyTail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = dummyTail;
        dummyTail.prev = node;
    }

}














