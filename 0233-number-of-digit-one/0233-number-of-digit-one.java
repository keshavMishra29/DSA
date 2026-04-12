class Solution {
    public int countDigitOne(int n) {
        int count = 0;

        for (long divider = 1; divider <= n; divider *= 10) {
            long high = n / (divider * 10);
            long curr = (n / divider) % 10;
            long low = n % divider;

            if (curr == 0) {
                count += high * divider;
            } else if (curr == 1) {
                count += high * divider + (low + 1);
            } else {
                count += (high + 1) * divider;
            }
        }

        return count;
    }
}