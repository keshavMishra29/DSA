class Solution {
    long MOD = (long) 10e8 + 7;

    public int xorAfterQueries(int[] nums, int[][] q) {
        int n = nums.length;
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (long) nums[i];
        }
        for (int i = 0; i < q.length; i++) {
            for (int j = q[i][0]; j <= q[i][1]; j += q[i][2]) {
                arr[j] = (arr[j] * (long) q[i][3]) % MOD;
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^ arr[i];
        }
        return (int) ans;
    }
}