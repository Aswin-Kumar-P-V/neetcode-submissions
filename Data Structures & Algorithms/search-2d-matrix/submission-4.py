class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix) - 1
        cols = len(matrix[0]) - 1
        l, r = 0, rows
        while l <= r : 
            mid = l + ((r -l) // 2)
            if target < matrix[mid][0]:
                r = mid - 1
            elif target > matrix[mid][-1]:
                l = mid + 1
            else:
                break
        row = l + ((r - l)//2)
        l, r = 0, cols
        while l <= r:
            mid = l + ((r - l)//2)
            if target < matrix[row][mid]:
                r = mid - 1
            elif target > matrix[row][mid]:
                l = mid + 1
            else:
                return True
        return False
        