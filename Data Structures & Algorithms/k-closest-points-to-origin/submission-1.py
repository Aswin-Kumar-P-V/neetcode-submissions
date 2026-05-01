class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        for i, point in enumerate(points):
            dist = point[0]**2 + point[1]**2
            points[i].insert(0,dist)
        heapq.heapify(points)
        res = []
        for i in range(k):
            dist, x, y = heapq.heappop(points)
            res.append([x,y])
        return res
        