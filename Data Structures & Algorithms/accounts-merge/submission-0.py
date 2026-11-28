class UnionFind:

    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.size = [1 for i in range(n)]
    
    def find(self, x):
        if self.parent[x] == x:
            return x
        while self.parent[x] != x:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        return x
    
    def union(self, a, b):
        p1, p2 = self.find(a), self.find(b)
        if p1 == p2:
            return False
        if self.size[p1] >= self.size[p2]:
            self.parent[p2] = p1
            self.size[p1] += self.size[p2]
        else:
            self.parent[p1] = p2
            self.size[p2] += self.size[p1]
        return True


class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        uf = UnionFind(len(accounts))
        emailAccIdx = {}
        for i, a in enumerate(accounts):
            for e in a[1:]:
                if e in emailAccIdx:
                    uf.union(i, emailAccIdx[e])
                else:
                    emailAccIdx[e] = i
        
        accEmails = defaultdict(list)

        for e, i in emailAccIdx.items():
            leader = uf.find(i)
            accEmails[leader].append(e)
        
        res = []

        for i, emails in accEmails.items():
            name = accounts[i][0]
            res.append([name] + sorted(emails))
        return res