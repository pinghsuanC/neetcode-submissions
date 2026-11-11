class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visit = new HashSet<>(Arrays.asList(deadends));
        if(visit.contains("0000")) return -1;

        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        visit.add("0000");

        int turns = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String lock = queue.poll();
                if(lock.equals(target)) return turns;
                for(String next : children(lock)){
                    if(!visit.contains(next)){
                        queue.offer(next);
                        visit.add(next);
                    }
                }
            }
            turns++;
        }

        return -1;
    }

    private List<String> children(String lock){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 4; i++){

            // turn forward 1 step
            char[] arr = lock.toCharArray();
            arr[i] = (char) ((((arr[i] - '0') + 1) % 10) + '0');
            res.add(new String(arr));

            // turn backward 1 step
            arr = lock.toCharArray();
            arr[i] = (char) (((arr[i] - '0' - 1 + 10) % 10) + '0');
            res.add(new String(arr));
        }
        return res;
    }
}