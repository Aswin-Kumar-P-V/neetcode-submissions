class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> colSet = new HashMap<>();
        Map<Integer, Set<Character>> rowSet = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();
        for(int r = 0; r < board.length;r++){
            for(int c = 0; c < board[0].length; c++){
                char el = board[r][c];
                if(el == '.'){
                    continue;
                }
                String key = (r/3) + "," + (c/3);
                if(colSet.computeIfAbsent(c, k ->new HashSet<>()).contains(el) || 
                rowSet.computeIfAbsent(r, k -> new HashSet<>()).contains(el) || 
                squares.computeIfAbsent(key, k-> new HashSet<>()).contains(el)){
                    return false;
                }
                rowSet.get(r).add(el);
                colSet.get(c).add(el);
                squares.get(key).add(el);
            }
        }
        return true;
    }
}
