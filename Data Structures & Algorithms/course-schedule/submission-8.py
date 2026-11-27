class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        pre_map = {c : [] for c in range(numCourses)}
        for crs, pre in prerequisites:
            pre_map[crs].append(pre)
        visited = set()
        
        def dfs(crs):
            if crs in visited:
                return False
            if pre_map[crs] == []:
                return True
            visited.add(crs)
            for pre in pre_map[crs]:
                if not dfs(pre):
                    return False
            pre_map[crs] = []
            visited.remove(crs)
            return True
        
        for c in range(numCourses):
            if not dfs(c):
                return False
        
        return True