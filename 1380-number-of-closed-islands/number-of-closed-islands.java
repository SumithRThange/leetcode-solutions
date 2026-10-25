class Solution {
    public int closedIsland(int[][] grid) {
        int noislands = 0;

        // Convert boundary-connected land (0) to water (1)
        for (int i = 0; i < grid.length; i++) {
            OneToZero(grid, i, 0);
            OneToZero(grid, i, grid[0].length - 1);
        }

        for (int j = 0; j < grid[0].length; j++) {
            OneToZero(grid, 0, j);
            OneToZero(grid, grid.length - 1, j);
        }

        // Count the remaining closed islands
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    noislands++;
                    OneToZero(grid, i, j);
                }
            }
        }

        return noislands;
    }

    private void OneToZero(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 ||
                i >= grid.length || j >= grid[0].length ||
                grid[i][j] == 1) {
            return;
        } else {
            grid[i][j] = 1;
        }

        OneToZero(grid, i + 1, j);
        OneToZero(grid, i - 1, j);
        OneToZero(grid, i, j + 1);
        OneToZero(grid, i, j - 1);
    }
}