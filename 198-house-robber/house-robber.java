class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return findhouse(n-1, nums, dp);
    }
    int findhouse(int ind, int[] nums, int[] dp){
        if(ind<0)
        return 0;
        if(ind == 0)
        return nums[0];
        if(dp[ind] != -1)
        return dp[ind];
        int pick = nums[ind] + findhouse(ind-2, nums, dp);
        int nonpick = findhouse(ind-1, nums, dp);
        return dp[ind] = Math.max(pick, nonpick);
    }
}