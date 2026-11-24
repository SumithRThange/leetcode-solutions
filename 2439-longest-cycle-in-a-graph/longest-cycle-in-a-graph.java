class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        int time = 0, ans = -1;
        for(int i=0;i<n;i++){
            if(visited[i]!=-1) continue;
            int curr = i, starttime = time;
            while(curr!=-1 && visited[curr]==-1){
                visited[curr] = time++;
                curr = edges[curr];
            }
            if(curr!=-1 && visited[curr] >= starttime){
                ans = Math.max(ans, time - visited[curr]);
            }
        }
        return ans;
    }
}