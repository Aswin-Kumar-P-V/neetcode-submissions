class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int r = 0; r < 9 ; r++){
            for(int c = 0; c < 9;c++){
                char el = board[r][c];
                if(el == '.') continue;
                String key = (r/3) + ","+ (c/3);
                if(rows.computeIfAbsent(r, k->new HashSet<>()).contains(el) || cols.computeIfAbsent(c, k->new HashSet<>()).contains(el)
                || squares.computeIfAbsent(key, k->new HashSet<>()).contains(el)){
                    return false;
                }
                rows.get(r).add(el);
                cols.get(c).add(el);
                squares.get(key).add(el);
            }
            
        }
        return true;
    }
}
