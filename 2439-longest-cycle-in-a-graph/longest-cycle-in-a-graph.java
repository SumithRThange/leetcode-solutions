class Solution {
    ArrayList<Integer>[] adj;
    boolean[] pathvisited, visited;
    int maxele = -1;
    public int longestCycle(int[] edge) {
        int n = edge.length;
        adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        pathvisited = new boolean[n];
        visited = new boolean[n];
        constructGraph(edge, n);
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
            }
        }
        return maxele;
    }
    private void constructGraph(int[] edge, int n){
        for(int i=0;i<n;i++){
            if(edge[i] != -1){
                adj[i].add(edge[i]);
            }
        }
    }
    private void dfs (int node){
        visited[node] = true;
        pathvisited[node] = true;
        for(int neighbour : adj[node]){
            if(!visited[neighbour]){
                dfs(neighbour);
            } else if(pathvisited[neighbour]){
                calculateCycleLength(neighbour);
            }
        }
        pathvisited[node] = false;
    }
    private void calculateCycleLength (int start){
        int curr = start, count = 0;
        do{
            count++;
            curr = adj[curr].get(0);
        } while (curr != start);
        maxele = Math.max(maxele, count);
    }
}