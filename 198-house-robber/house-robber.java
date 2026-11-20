class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
       int[] dp = new int[n];
       Arrays.fill(dp, -1);
       return rob(n-1, dp, nums); 
    }
    private int rob (int index, int[] dp, int[] nums){
        if(index < 0)
        return 0;
        if(index == 0)
        return nums[0];
        if(dp[index] != -1)
        return dp[index];
        int pick = nums[index] + rob(index-2, dp, nums);
        int notpick = rob(index - 1, dp, nums);
        return dp[index] = Math.max(pick, notpick);
    }
}