class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        adjlist = {c : set() for w in words for c in w}

        for i in range(1, len(words)):
            w1, w2 = words[i-1], words[i]
            min_len = min(len(w1), len(w2))
            if len(w1) > len(w2) and w1[:min_len] == w2[:min_len]:
                return ""
            for j in range(min_len):
                if w1[j] != w2[j]:
                    adjlist[w1[j]].add(w2[j])
                    break
        
        visited= set()
        cycle = set()
        res = []

        def dfs(c):
            if c in cycle:
                return False
            if c in visited:
                return True
            cycle.add(c)
            for neigh in adjlist[c]:
                if not dfs(neigh):
                    return False
            cycle.remove(c)
            visited.add(c)
            res.append(c)
            return True

        for c in adjlist:
            if not dfs(c):
                return ""
        res.reverse()
        return "".join(res) 