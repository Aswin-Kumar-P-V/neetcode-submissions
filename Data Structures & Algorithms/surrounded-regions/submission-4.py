class Solution:
    def solve(self, board: List[List[str]]) -> None:
        rows, cols = len(board), len(board[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        def dfs(r, c):
            if r < 0 or c < 0 or r >= len(board) or c >= len(board[0]) or board[r][c] != "O":
                return
            board[r][c] = "T"
            for rd, cd in directions:
                dfs(r + rd, c + cd)
        
        for r in range(rows):
            dfs(r, 0)
            dfs(r, cols-1)
        
        for c in range(cols):
            dfs(0, c)
            dfs(rows - 1, c)
        
        for r in range(rows):
            for c in range(cols):
                if board[r][c] == "O":
                    board[r][c] = "X"
                elif board[r][c] == "T":
                    board[r][c] = "O"
