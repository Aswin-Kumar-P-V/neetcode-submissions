class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char el = board[r][c];
                if(el == '.') continue;
                String key = (r / 3) + "," + (c / 3);
                if(rowMap.computeIfAbsent(r, k -> new HashSet<>()).contains(el) ||
                colMap.computeIfAbsent(c, k -> new HashSet<>()).contains(el) || 
                squares.computeIfAbsent(key, k -> new HashSet<>()).contains(el)){
                    return false;
                }
                rowMap.get(r).add(el);
                colMap.get(c).add(el);
                squares.get(key).add(el);
            }
        }
        return true;
    }
}
