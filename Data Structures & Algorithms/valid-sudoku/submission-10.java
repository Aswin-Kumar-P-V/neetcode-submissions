class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> colsMap = new HashMap<>();
        Map<Integer, Set<Character>> rowsMap = new HashMap<>();
        Map<String, Set<Character>> squareMap = new HashMap<>();

        for(int r = 0 ; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char val = board[r][c];
                if(val == '.'){
                    continue;
                }
                String squareKey = (r/3) + "." + (c/3);
                if(colsMap.computeIfAbsent(r, k -> new HashSet<>()).contains(val) ||
                rowsMap.computeIfAbsent(c, k -> new HashSet<>()).contains(val) || 
                squareMap.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(val)){
                    return false;
                }
                colsMap.get(r).add(val);
                rowsMap.get(c).add(val);
                squareMap.get(squareKey).add(val);
            }
        }
        return true;
    }
    
}
