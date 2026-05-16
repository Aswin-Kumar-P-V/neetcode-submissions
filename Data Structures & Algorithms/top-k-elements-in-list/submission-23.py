class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = Counter(nums)
        freq = [[] for i in range(len(nums) + 1)]
        for key in map:
            freq[map[key]].append(key)
        index = 0
        res = []
        for i in range(len(nums) , 0, -1):
            for num in freq[i]:
                res.append(num)
                index += 1
                if index == k:
                    return res
        