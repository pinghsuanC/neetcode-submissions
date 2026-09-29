class MinStack {
    int min = Integer.MAX_VALUE;
    ArrayList<Integer> arr = new ArrayList<Integer>();
    public MinStack() {
    }
    
    public void push(int val) {
        min = Math.min(val, min);
        arr.add(val);
    }
    
    public void pop() {
        int ele = arr.remove(arr.size()-1);
        if(ele == min){
            // find minimun
            this.min = Integer.MAX_VALUE;
            for(int k : arr){
                this.min = Math.min(this.min, k);
            }
        }
    }
    
    public int top() {
        System.out.println(arr.size()-1);
        int res = arr.get(arr.size()-1);
        //this.pop();
        return res;
    }
    
    public int getMin() {
        return min;
    }
}
