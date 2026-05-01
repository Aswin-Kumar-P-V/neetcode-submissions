class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = defaultdict(set)
        cols = defaultdict(set)
        squares = defaultdict(set)

        for r in range(len(board)):
            for c in range(len(board[0])):
                element = board[r][c]
                if element == ".":
                    continue
                key = (r//3, c//3)
                if element in rows[r] or element in cols[c] or element in squares[key]:
                    return False
                rows[r].add(element)
                cols[c].add(element)
                squares[key].add(element)
        return True
        