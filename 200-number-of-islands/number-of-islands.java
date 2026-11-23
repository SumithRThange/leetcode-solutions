class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int noisland = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    noisland++;
                    landtowater(grid, i, j);
                }
            }
        }
        return noisland;
    }

    private void landtowater(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        landtowater(grid, i-1, j);
        landtowater(grid, i+1, j);
        landtowater(grid, i, j-1);
        landtowater(grid, i, j+1);
    }
}