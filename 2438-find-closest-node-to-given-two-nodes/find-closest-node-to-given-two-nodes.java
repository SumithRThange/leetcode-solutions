class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int ans = -1, mindist = Integer.MAX_VALUE, n = edges.length;
        int[] dist1 = getDistance(edges, node1);
        int[] dist2 = getDistance(edges, node2);
        for(int i=0;i<n;i++){
            if(dist1[i] != -1 && dist2[i] != -1){
                int maxdist = Math.max(dist1[i], dist2[i]);
                if(maxdist < mindist){
                    mindist = maxdist;
                    ans = i;
                }
            }
        }
        return ans;
    }

    private int[] getDistance (int[] edges, int start){
        int n = edges.length, curr = start;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int vis = 0;
        while(curr != -1 && dist[curr] == -1){
            dist[curr] = vis++;
            curr = edges[curr];
        }
        return dist;
    }
}