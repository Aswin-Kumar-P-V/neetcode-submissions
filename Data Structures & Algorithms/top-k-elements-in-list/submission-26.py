class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqMap = Counter(nums)
        bucket = [[] for i in range(len(nums) + 1)]
        for num, cnt in freqMap.items():
            bucket[cnt].append(num)
        res = []
        for i in range(len(nums),-1,-1):
            for el in bucket[i]:
                res.append(el)
                k -= 1
                if k == 0:
                    return res
        
