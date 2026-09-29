class Twitter {
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> follows;
    int time = 0;

    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<int[]>());
        tweets.get(userId).add(new int[]{time, tweetId});
        time++;
        follows.putIfAbsent(userId, new HashSet<Integer>());
        follows.get(userId).add(userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!follows.containsKey(userId)) return new ArrayList<Integer>();
        PriorityQueue<int[]> feed = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i : follows.get(userId)){
            for(int[] tw : tweets.get(i)){
                feed.offer(tw);
                if(feed.size() > 10) {
                    int[] ele = feed.poll();
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!feed.isEmpty()){
            res.add(feed.poll()[1]);
        }
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).remove(followeeId);
    }
}
