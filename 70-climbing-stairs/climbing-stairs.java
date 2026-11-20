class Solution {
    public int climbStairs(int n) {
        int[] dp = new int [n+1];
        return climbStairs (n, dp);
    }
    private int climbStairs (int n, int[] dp){
        if(n<=2){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = climbStairs(n-1, dp) + climbStairs(n-2, dp);
        return dp[n];
    }
}