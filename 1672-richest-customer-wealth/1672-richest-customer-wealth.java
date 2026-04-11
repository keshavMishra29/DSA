class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int temp = 0;
        int n = accounts.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                temp += accounts[i][j];
            }
            if (temp > max) {
                max = temp;
            }
            temp = 0;
        }
        return max;
    }
}