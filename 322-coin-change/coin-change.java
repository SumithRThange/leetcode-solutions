class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] mincoin = new int [amount + 1];
        Arrays.fill(mincoin, -1);
        int ans = minCoinsDp(coins, amount, mincoin);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int minCoinsDp (int[] coins, int amount, int[] mincoin){
        if(amount == 0){
            return 0;
        } if(amount < 0){
            return Integer.MAX_VALUE;
        } if(mincoin[amount] != -1){
            return mincoin[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int result = minCoinsDp(coins, amount - coins[i], mincoin);
            if(result != Integer.MAX_VALUE){
                min = Math.min(min, 1+result);
            }
        }
        return mincoin[amount] = min;
    }
}