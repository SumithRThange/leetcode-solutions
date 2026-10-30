class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++){
            convertOto1(board, i, 0);
            convertOto1(board, i, n-1);
        }
        for(int j=0;j<n;j++){
            convertOto1(board, 0, j);
            convertOto1(board, m-1, j);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if (board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void convertOto1(char[][] board,int row, int col){
        int m = board.length, n = board[0].length;
        if(row < 0 || col < 0 || row >= m || col >= n || board[row][col] != 'O'){
            return;
        }
        board[row][col] = '1';
        convertOto1(board, row+1, col);
        convertOto1(board, row-1, col);
        convertOto1(board, row, col+1);
        convertOto1(board, row, col-1);
    }
}