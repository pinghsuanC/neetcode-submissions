/*
    solve with frequency bucket + hashmap to achieve O(1)
*/


class ListNode{
    ListNode prev;
    ListNode next;
    int key, value, counter;

    public ListNode(){
        key = -1;
        value = -1;
        counter = -1;
        prev = null;
        next = null;
    }

    public ListNode(int k, int v){
        key = k;
        value = v;
        counter = 1;
        prev = null;
        next = null;
    }

    public ListNode(int k, int v, ListNode p, ListNode n){
        key = k;
        value = v;
        counter = 1;
        prev = p;
        next = n;
    }
}

class FrequencyBucket{
    // probably can make this better but let's just use it for now
    ListNode head, tail;
    int size;

    public FrequencyBucket(){
        head = new ListNode();
        tail = new ListNode();
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public void add(ListNode node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    public void remove(ListNode node){
        detach(node);
        size--;
    }

    public ListNode pop(){
        if(size == 0) return null;

        ListNode node = head.next;
        remove(node);
        return node;
    }

    private void detach(ListNode node){
        if(node == head || node == null) return; // can't detach the head
        ListNode prev = node.prev;
        ListNode next = node.next;
        node.prev = null;
        node.next = null;

        if(prev!=null) prev.next = next;
        if(next!=null) next.prev = prev;
    }

}

class LFUCache {


    int cap, size;
    Map<Integer, ListNode> nodeMap;
    Map<Integer, FrequencyBucket> buckets;
    int minFreq;

    public LFUCache(int capacity) {
        cap = capacity;
        size = 0;
        minFreq = 0;
        nodeMap = new HashMap<>();
        buckets = new HashMap<>();
    }
    
    public int get(int key) {
        if(cap == 0) return -1;
        if(!nodeMap.containsKey(key)) return -1;

        // node has the key, so return value + move it to the next frequency bucket
        // get value
        ListNode target = nodeMap.get(key);
        
        // manage frequency bucket
        moveToNextBucket(target);
        
        return target.value;
    }
    
    public void put(int key, int value) {
        if(cap == 0) return;

        if(nodeMap.containsKey(key)){
            ListNode target = nodeMap.get(key);
            target.value = value;
            moveToNextBucket(target);
        } else {
            // see if the capacity is reached
            if(size == cap) {
                ListNode evicted = buckets.get(minFreq).pop();
                nodeMap.remove(evicted.key);
                size--;
            }
            if(minFreq > 0 && buckets.get(minFreq).size == 0) buckets.remove(minFreq);
            ListNode newNode = new ListNode(key, value);
            buckets.putIfAbsent(1, new FrequencyBucket());
            FrequencyBucket targetBucket = buckets.get(1);
            targetBucket.add(newNode);
            minFreq = 1; // now it has to be 1
            size++;

            nodeMap.put(key, newNode);
        }
    }

    private void moveToNextBucket(ListNode node){
        FrequencyBucket oldBucket = buckets.get(node.counter);
        oldBucket.remove(node);
        if(oldBucket.size == 0) {
            buckets.remove(node.counter);
            if(minFreq == node.counter) minFreq = node.counter + 1;
        }

        // increment counter in node, add to new bucket
        node.counter++;
        buckets.putIfAbsent(node.counter, new FrequencyBucket());
        FrequencyBucket newBucket = buckets.get(node.counter);
        newBucket.add(node);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */