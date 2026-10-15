class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = defaultdict(set)
        cols = defaultdict(set)
        squares = defaultdict(set)

        for r in range(9):
            for c in range(9):
                el = board[r][c]
                if el == ".":
                    continue
                squareKey = (r//3, c//3)
                if el in rows[r] or el in cols[c] or el in squares[squareKey]:
                    return False
                rows[r].add(el)
                cols[c].add(el)
                squares[squareKey].add(el)
        return True