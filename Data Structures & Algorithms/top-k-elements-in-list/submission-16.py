class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frequency = [[] for i in range(len(nums) + 1)]
        map = {}
        for num in nums:
            map[num] = 1 + map.get(num, 0)
        for key in map:
            frequency[map[key]].append(key)
        res = []
        for i in range(len(frequency) - 1, 0, -1):
            for num in frequency[i]:
                res.append(num)
                if len(res) == k:
                    return res