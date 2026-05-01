class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])
        l = 0
        r = rows - 1
        while l <= r :
            mid = l + ((r - l) //2)
            if target < matrix[mid][0]:
                r = mid - 1
            elif target > matrix[mid][-1]:
                l = mid + 1
            else:
                break
        if l > r:
            return False
        row = l + ((r-l)//2)
        l = 0
        r = cols - 1
        while l <= r:
            mid = l +((r-l)//2)
            if target < matrix[row][mid]:
                r = mid - 1
            elif target > matrix[row][mid]:
                l = mid + 1
            else:
                return True
        return False
        
        