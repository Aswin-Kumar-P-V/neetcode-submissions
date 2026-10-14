class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqMap = {}
        for num in nums:
            freqMap[num] = 1 + freqMap.get(num, 0)
        arr = []
        for num, cnt in freqMap.items():
            arr.append([cnt, num])
        arr.sort()
        res = []
        for i in range(k):
            res.append(arr.pop()[1])
        return res