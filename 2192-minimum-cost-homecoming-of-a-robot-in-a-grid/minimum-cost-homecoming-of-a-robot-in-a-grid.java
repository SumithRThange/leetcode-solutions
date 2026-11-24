class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int i = startPos[0], j = startPos[1];
        int x = homePos[0], y = homePos[1];
        int mincost = 0;
        while(i != x){
            i += i < x ? 1 : -1;
            mincost += rowCosts[i];
        }
        while(j != y){
            j += j < y ? 1 : -1;
            mincost += colCosts[j];
        }
        return mincost;
    }
}