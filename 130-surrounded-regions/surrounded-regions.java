class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            convertboundary(board, i, 0);
            convertboundary(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            convertboundary(board, 0, j);
            convertboundary(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void convertboundary(char[][] board, int r, int c)
    {
        int m = board.length, n = board[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O') {
            return;
        }
        board[r][c] = '#';
        convertboundary(board, r + 1, c);
        convertboundary(board, r - 1, c);
        convertboundary(board, r, c + 1);
        convertboundary(board, r, c - 1);
    }
}