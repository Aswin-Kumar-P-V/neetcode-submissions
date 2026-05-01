class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = {}
        for s in strs:
            map[''.join(sorted(s))] = []
        for s in strs:
            map[''.join(sorted(s))].append(s)
        return list(map.values())