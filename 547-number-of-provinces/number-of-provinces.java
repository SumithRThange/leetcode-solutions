class Solution {
    public int findCircleNum(int[][] isConnected) {
       int n = isConnected.length, count = 0;
       boolean[] vis = new boolean[n+1];
       for(int i=0;i<n;i++){
        if(!vis[i]){
            count++;
            dfs(i, vis, isConnected);
        }
       } 
       return count;
    }
    private void dfs(int node, boolean[] vis, int[][] isConnected){
        vis[node] = true;
        for(int j=0;j<isConnected.length;j++){
            if(!vis[j] && isConnected[node][j] == 1){
                dfs(j, vis, isConnected);
            }
        }
    }
}