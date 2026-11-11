class Twitter:

    def __init__(self):
        self.followers_map = defaultdict(set)
        self.tweets = defaultdict(list)
        self.time = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets[userId].append([self.time, tweetId])
        self.time -= 1

    def getNewsFeed(self, userId: int) -> List[int]:
        user_list = self.followers_map[userId]
        user_list.add(userId)
        res = []
        for user in user_list:
            if self.tweets[user]:
                res.extend(self.tweets[user])
        res.sort()
        length = len(res)
        return [tweetId for _, tweetId in res[:10]]

    def follow(self, followerId: int, followeeId: int) -> None:
        self.followers_map[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if self.followers_map[followerId] and followeeId in self.followers_map[followerId]:
            self.followers_map[followerId].remove(followeeId)
