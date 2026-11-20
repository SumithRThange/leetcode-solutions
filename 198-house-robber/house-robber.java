class Solution {
    public int rob(int[] nums) {
     int n = nums.length;
     int[] dp = new int[n+1];
     Arrays.fill(dp, -1);
     return rob(n-1, dp, nums);   
    }
    private int rob(int position, int[] dp, int[] nums){
         if (position == 0){
            return nums[0];
        } if (position < 0){
            return 0;
        } if (dp[position] != -1){
            return dp[position];
        }
        int pick = nums[position] + rob(position-2, dp, nums);
        int notpick = rob(position-1, dp, nums);
        return dp[position] = Math.max(pick, notpick);
    }
}