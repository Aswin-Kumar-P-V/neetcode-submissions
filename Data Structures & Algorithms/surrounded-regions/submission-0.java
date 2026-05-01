class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;

        for(int c = 0; c < cols; c++){
            if(board[0][c] == 'O'){
                capture(0, c, board);
            }
            if(board[rows - 1][c] == 'O'){
                capture(rows - 1, c, board);
            }
        }

        for(int r = 0; r < rows; r++){
            if(board[r][0] == 'O'){
                capture(r, 0, board);
            }
            if(board[r][cols - 1] == 'O'){
                capture(r, cols-1, board);
            }
        }
        for(int r = 0 ; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }else if(board[r][c] == 'A'){
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void capture(int r, int c, char[][] board){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') return;
        board[r][c] = 'A';
        capture(r + 1, c , board);
        capture(r - 1, c , board);
        capture(r , c + 1, board);
        capture(r , c - 1, board);
    }
}
