class Solution {
    int[] result;
    public int[] finalPrices(int[] prices) {
        result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            result[i] = findPrice(prices, i);
        }
        return result;
    }

    private int findPrice(int[] prices, int index) {
        for (int i = index + 1; i < prices.length; i++) {
            if (prices[i] <= prices[index]) {
                return prices[index] - prices[i];
            }
        }
        return prices[index];
    }
}