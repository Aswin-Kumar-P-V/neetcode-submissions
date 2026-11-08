class Twitter:

    def __init__(self):
        self.user_follower = defaultdict(set)
        self.posts = []
        self.time = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.time += 1
        heapq.heappush(self.posts, [-self.time, userId, tweetId])

    def getNewsFeed(self, userId: int) -> List[int]:
        tweets = []
        posts_copy = self.posts.copy()
        followers = self.user_follower[userId]
        while posts_copy and len(tweets) < 10:
            post = heapq.heappop(posts_copy)
            if post[1] == userId:
                tweets.append(post[2])
            elif followers and post[1] in followers:
                tweets.append(post[2])
        return tweets

    def follow(self, followerId: int, followeeId: int) -> None:
        self.user_follower[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId in self.user_follower and followeeId in self.user_follower[followerId]:
            self.user_follower[followerId].remove(followeeId)