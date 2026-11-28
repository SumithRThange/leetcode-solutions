class Solution {
    public class Pair{
        int row, col, tm;
        Pair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
    }
    public int orangesRotting(int[][] grid) {
        int fresh = 0, m = grid.length, n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else if (grid[i][j] == 0){
                    vis[i][j] = 0;
                } else if (grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int tm = 0, cnt = 0;
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int t = p.tm;
            tm = Math.max(tm, t);
            for(int i=0;i<4;i++){
                int nr = r + drow[i];
                int nc = c + dcol[i];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && vis[nr][nc] == 0){
                    q.add(new Pair(nr, nc, t+1));
                    vis[nr][nc] = 2;
                    cnt++;
                }
            }
        }
        return cnt == fresh ? tm : -1;
    }
}