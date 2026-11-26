class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairs(n, dp);
    }
    private int climbStairs(int n, int[] dp){
        if(n<=2){
            return n;
        }
        if(n<0){
            return -1;
        } if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = climbStairs(n-1, dp) + climbStairs(n-2, dp);
    }
}