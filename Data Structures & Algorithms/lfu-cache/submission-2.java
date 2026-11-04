class ListNode {
    public int key, value, counter;
    public ListNode next;
    public ListNode prev;
    
    public ListNode(int k, int v){
        key = k;
        value = v;
        counter = 1;
        next = null;
        prev = null;
    }

    public ListNode(){
        key = -1;
        value = -1;
        counter = -1;
        next = null;
        prev = null;
    }

}



class LFUCache {
    /*
    general intuition: with single / doubly linkedlist
    move the most recently used items to the end of the list every time, so the head will always be the least recently used
    removeal takes O(1), but get may take O(n)
    to reduce get time, have a pointer to point to the tail, move everytime a cache is used, this should gives O(1)
    track the size and check capacity int the process

    hashmap to easily locate the node helps too
    */

    int cap, size;
    ListNode head, tail;
    Map<Integer, ListNode> map;
    // initially: head <=> tail

    public LFUCache(int capacity) {
        cap = capacity;
        size = 0;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
        head.counter = Integer.MIN_VALUE;
        tail.counter = Integer.MAX_VALUE;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        ListNode target = map.get(key);
        target.counter++;
        positionNode(target);
        //System.out.println("getting " + key + " result:" + target.value);
        //print();
        return target.value;
    }
    
    public void put(int key, int value) {
        if(cap == 0) return;
        //System.out.println("inserting (" + key + ", " + value + ")");
        // not found
        if(!map.containsKey(key)){
            // check size if we need to burst the least frequently used
            if(size == cap){
                ListNode tmp = head.next;
                head.next = tmp.next;
                tmp.next.prev = head;
                tmp.next = null;
                tmp.prev = null;
                // clean up hashmap 
                map.remove(tmp.key); 
                size--;
            }

            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            
            // attach between head & head.next
            ListNode tmp = head.next;
            head.next = newNode;
            newNode.prev = head;
            newNode.next = tmp;
            tmp.prev = newNode;
            size++;

            positionNode(newNode);
        } else {
            // found
            ListNode pt = map.get(key);
            pt.value = value;
            pt.counter++;

            // move it to the tail since it's used. don't need to touch the hashmap
            // detach pt from the chain first
            positionNode(pt);
        }
        // print();
    }

    private void positionNode(ListNode node){
        if(node.counter < node.next.counter && node.counter > node.prev.counter) return; // no need to move it
        // note that if it's a tie, we still need to move it to the end

        // detach node from prev and next
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;

        // find the correct position
        ListNode pt = head;
        while(pt!= null && pt.counter <= node.counter){
            pt = pt.next;
        }

        // attach it to correct position before pt
        ListNode ptPrev = pt.prev;
        ptPrev.next = node;
        node.prev = ptPrev;
        pt.prev = node;
        node.next = pt;
    }


    private void print(){
        ListNode pt = head;
        while(pt!= null){
            System.out.print("(" + pt.key + ", " + pt.value + ", " + pt.counter + ")");
            pt = pt.next;
        }
        System.out.println();
        // System.out.println("\n------------------------------");
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */