class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = [[] for i in range(len(nums)+1)]
        freq_map = Counter(nums)
        for num in freq_map:
            freq[freq_map[num]].append(num)
        res = []
        for i in range(len(freq) - 1, -1,-1):
            for num in freq[i]:
                res.append(num)
                if len(res) == k:
                    return res
        return res

        