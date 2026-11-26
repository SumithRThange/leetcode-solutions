class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1)
        return 0;
        int[] mincoin = new int[amount + 1];
        for(int i=1;i<=amount;i++){
            mincoin[i] = Integer.MAX_VALUE;

            for(int coin : coins){
                if(coin <= i && mincoin[i-coin] != Integer.MAX_VALUE){
                    mincoin[i] = Math.min(mincoin[i], 1 + mincoin[i-coin]);
                }
            }
        }
        return mincoin[amount] == Integer.MAX_VALUE ? -1 : mincoin[amount];
    }
}