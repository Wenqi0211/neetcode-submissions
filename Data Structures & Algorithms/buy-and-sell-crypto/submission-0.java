class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxP = 0;
        while (right < prices.length) {
            int profit = prices[right] - prices[left];
            if (prices[left] < prices[right]){
                profit = prices[right] - prices[left];
                maxP = Math.max(maxP, profit);
            }
            else {
                left = right;
            }
            right++;
        }
        return maxP;
    }
}
