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
        if(tweets.get(userId).size() > 10) tweets.get(userId).remove(0);
        time++;
        follows.putIfAbsent(userId, new HashSet<Integer>());
        follows.get(userId).add(userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!follows.containsKey(userId)) return new ArrayList<Integer>();
        PriorityQueue<int[]> feed = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Integer> followees = follows.get(userId);

        // push the latest tweet from each user onto heap, track user id and index
        for(int followeeId : followees){
            List<int[]> tws = tweets.get(followeeId);
            if(tws == null || tws.size() == 0) continue;
            int[] latest = tws.get(tws.size() - 1);
            feed.offer(new int[]{
                latest[0],
                latest[1],
                followeeId,
                tws.size() - 1
            });
        }

        // construct res
        List<Integer> res = new ArrayList<>();
        while(!feed.isEmpty() && res.size() < 10){
            int[] top = feed.poll();
            res.add(top[1]);
            int ind = top[3]-1;
            if(ind >= 0){
                int uId = top[2];
                List<int[]> tws = tweets.get(uId);
                feed.offer(new int[]{
                    tws.get(ind)[0],
                    tws.get(ind)[1],
                    uId,
                    ind
                });
            }
        }
        
        //Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followerId);
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).remove(followeeId);
    }
}
