class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = defaultdict(int)
        for num in nums:
            map[num] += 1
        freq = [[] for i in range(len(nums) + 1)]
        for key in map:
            freq[map[key]].append(key)
        res = [0 for i in range(k)]
        index = 0
        for i in range(len(freq) - 1, -1, -1):
            for num in freq[i]:
                res[index] = num
                index += 1
                if index == k:
                    return res
        return res