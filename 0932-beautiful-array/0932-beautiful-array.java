class Solution {
    public int[] beautifulArray(int n) {
        return build(n);
    }

    private int[] build(int n) {
        if (n == 1)
            return new int[] { 1 };
        int[] left = build((n + 1) / 2);
        int[] right = build(n / 2);

        int[] res = new int[n];
        int idx = 0;
        for (int x : left) {
            res[idx++] = 2 * x - 1;
        }
        for (int x : right) {
            res[idx++] = 2 * x;
        }

        return res;
    }
}