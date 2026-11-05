class Twitter {
    int time = 0;
    //1 -> {2} follower->followee
    Map<Integer, Set<Integer>> followMap = new HashMap<>();
    //1 -> {0, 10} 2 ->{1, 20} 
    Map<Integer, List<int[]>> tweetMap = new HashMap<>();
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time, tweetId});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // add the people who you follow
        Set<Integer> people = new HashSet<>();
        people.add(userId);
        if (followMap.containsKey(userId)) {
            people.addAll(followMap.get(userId));
        }

        // bulid max-heap
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for (int person : people) {
            if (tweetMap.containsKey(person)) {
                for (int[] tweet : tweetMap.get(person)) {
                    maxHeap.add(tweet);
                }
            }
        }

        // return recent posts
        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] top = maxHeap.poll();
            result.add(top[1]);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
