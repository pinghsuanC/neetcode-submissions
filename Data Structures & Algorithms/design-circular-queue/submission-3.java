class ListNode{
    ListNode next;
    ListNode pre;
    Integer val;
    ListNode(int i){
        val = i;
        next = null;
        pre = null;
    }
    ListNode(){
        val = null;
    }

    public void clearValue(){
        val = null;
    }
}


class MyCircularQueue {

    private ListNode head; // pointing to the first element of the queue
    private ListNode tail; // pointing to the last element of the queue

    public MyCircularQueue(int k) {
        
        // create k empty nodes
        ListNode dummyHead = new ListNode();
        ListNode tmp = dummyHead;
        for(int i = 0; i < k; i++){
            ListNode n = new ListNode();
            n.pre = tmp;
            tmp.next = n;
            tmp = tmp.next;
        }

        

        // setting pre & next for head and tail
        head = dummyHead.next; // move to starting point of the position
        tmp.next = head;
        head.pre = tmp;

        tail = head; // tail points to the last element of the queue
        dummyHead.next = null; // detach dummy head
        
    }
    
    public boolean enQueue(int value) {
        // create a new linked node
        ListNode n = new ListNode(value);

        // first element
        if(head.val == null){
            head.val = value;
            return true;
        }
        if(tail.next.val != null) return false; // tail.next is empty or not
        tail.next.val = value;
        tail = tail.next;
        
        return true;
    }
    
    public boolean deQueue() {
        // need to move the head now
        if(head.val == null) return false; // don't have anything in queue now
        // clear the val
        head.clearValue();
        head = head.next; // point to the next value in queue.
        if(head.val == null) tail = head;
        return true;
    }
    
    public int Front() {
        if(head.val == null) return -1;
        return head.val;
    }
    
    public int Rear() {
        if(tail.val == null) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return head.val == null;
    }
    
    public boolean isFull() {
        return tail.next.val != null;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */