class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, count = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(isConnected, i, vis);
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected, int node, boolean[] vis){
        vis[node] = true;
        for(int j=0;j<isConnected.length;j++){
            if(!vis[j] && isConnected[node][j] == 1){
                dfs(isConnected, j, vis);
            }
        }
    }
}