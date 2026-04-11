class Twitter {

    private class Tweet {

        private int id;
        private int time;

        private Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
        }
    }

    private class TweetPointer {

        private List<Tweet> tweets;
        private int index;

        public TweetPointer(List<Tweet> tweets, int index) {
            this.tweets = tweets;
            this.index = index;
        }

        public Tweet getTweet() {
            return this.tweets.get(this.index);
        }
    }

    private int timeStamp = 0;
    // one map to handle users and their own tweets
    private HashMap<Integer, List<Tweet>> userMap;
    // one map to handle users and who they follow
    private HashMap<Integer, HashSet<Integer>> followeeMap;

    public Twitter() {
        this.userMap = new HashMap<>();
        this.followeeMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        // perform lookup on user and add to their tweets
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new ArrayList<>());
        }

        Tweet newTweet = new Tweet(tweetId);
        userMap.get(userId).add(newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        PriorityQueue<TweetPointer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getTweet().time, a.getTweet().time)
        );

        // get user's tweets and add to heap
        if (userMap.containsKey(userId)) {
            List<Tweet> userTweets = userMap.get(userId);
            if (!userTweets.isEmpty()) {
                TweetPointer mostRecent = new TweetPointer(userTweets, userTweets.size() - 1);
                maxHeap.offer(mostRecent);
            }
        }

        // get followee's tweets and add to heap
        if (followeeMap.containsKey(userId)) {
            Set<Integer> followees = followeeMap.get(userId);
            // loop through each followee and add their most recent tweet to the heap
            for (int followeeId : followees) {
                if (userMap.containsKey(followeeId)) {
                    List<Tweet> followeeTweets = userMap.get(followeeId);
                    if (!followeeTweets.isEmpty()) {
                        TweetPointer mostRecent = new TweetPointer(followeeTweets,
                        followeeTweets.size() - 1);
                        maxHeap.offer(mostRecent);
                    }
                }
            }
        }

        // add the most recent tweets to the news feed
        while (!maxHeap.isEmpty() && newsFeed.size() < 10) {
            TweetPointer pointer = maxHeap.poll();
            Tweet recentTweet = pointer.getTweet();
            newsFeed.add(recentTweet.id);
            
            if (pointer.index > 0) { // there are more tweets in the list
                pointer.index--;
                maxHeap.offer(pointer);
            }
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        // a user should not be able to follow themselves
        if (followerId == followeeId) {
            return;
        }
        // perform lookup on user and add to their followee list
        if (!followeeMap.containsKey(followerId)) {
            followeeMap.put(followerId, new HashSet<>());
        }

        followeeMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followeeMap.containsKey(followerId)) {
            followeeMap.get(followerId).remove(followeeId);
        }
    }
}
