class ListNode{

    ListNode next;
    Integer value;
    Integer key;

    ListNode(){
        next = null;
        value = null;
        key = null;
    }

    ListNode(int key, int value){
        this.key = key;
        this.value = value;
        next = null;
    }
}


class MyHashMap {

    ListNode head;

    public MyHashMap() {
        head = new ListNode();
    }
    
    public void put(int key, int value) {
       ListNode cur = head;
       while(cur.next != null && cur.next.key != key) {
        cur = cur.next;
       }
       if(cur.next == null) cur.next = new ListNode(key, value);
       cur.next.value = value;
    }
    
    public int get(int key) {
        ListNode cur = head;
       while(cur.next != null && cur.next.key != key) {
        cur = cur.next;
       }
       if(cur.next == null) return -1;
       return cur.next.value;
    }
    
    public void remove(int key) {
        ListNode cur = head;
        while(cur.next != null && cur.next.key != key) {
            cur = cur.next;
        }
        if(cur.next == null) return;
        cur.next = cur.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */