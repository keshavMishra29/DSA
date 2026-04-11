class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {

        if (arr.length <= 2) {
            return true;
        }

        int n = arr.length;
        int max = arr[0], min = arr[0];
        for (int i = 1; i < n; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        if (min == max) {
            return true;
        }

        if ((max - min) % (n - 1) != 0) {
            return false;
        }

        int d = (max - min) / (n - 1);
        boolean[] seen = new boolean[n];

        for (int i = 0; i < arr.length; i++) {
            int diff = arr[i] - min;
            if (diff % d != 0) {
                return false;
            }
            int index = diff / d;
            if (index >= n || index < 0 || seen[index]) {
                return false;
            }
            seen[index] = true;
        }
        return true;
    }
}