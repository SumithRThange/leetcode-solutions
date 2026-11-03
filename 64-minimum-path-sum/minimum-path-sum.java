class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int top = i-1 < 0 ? Integer.MAX_VALUE : grid[i-1][j];
                int left = j-1 < 0 ? Integer.MAX_VALUE : grid[i][j-1];
                int min = top == Integer.MAX_VALUE && left == Integer.MAX_VALUE ? 0 : Math.min(top, left);
                grid[i][j] += min;
            }
        }
        return grid[m-1][n-1];
    }
}