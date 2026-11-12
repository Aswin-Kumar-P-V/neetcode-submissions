class Twitter:

    def __init__(self):
        self.followers_map = defaultdict(set)
        self.tweets = defaultdict(list)
        self.time = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        index = len(self.tweets[userId])
        self.tweets[userId].append([self.time, tweetId, userId, index])
        self.time -= 1

    def getNewsFeed(self, userId: int) -> List[int]:
        users = self.followers_map[userId]
        users.add(userId)
        min_heap = []
        for user in users:
            if self.tweets[user]:
                heapq.heappush(min_heap, self.tweets[user][-1])
        res = []
        while min_heap and len(res) < 10:
            _, tweetId, userId, index = heapq.heappop(min_heap)
            res.append(tweetId)
            if index > 0:
                heapq.heappush(min_heap, self.tweets[userId][index-1])
        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        self.followers_map[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if self.followers_map[followerId] and followeeId in self.followers_map[followerId]:
            self.followers_map[followerId].remove(followeeId)
