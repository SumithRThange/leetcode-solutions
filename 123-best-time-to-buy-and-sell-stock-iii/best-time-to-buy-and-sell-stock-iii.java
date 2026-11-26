class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE, sell1 = 0, sell2 = 0;
        for(int num : prices){
            buy1 = Integer.max(buy1, -num);
            sell1 = Integer.max(sell1, num + buy1);
            buy2 = Integer.max(buy2, sell1 - num);
            sell2 = Integer.max(sell2, num + buy2);
        } 
        return sell2;
    }
}