import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        // store (start, index)
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        // sort by start
        Arrays.sort(starts, (a, b) -> a[0] - b[0]);

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];

            int idx = binarySearch(starts, end);
            result[i] = idx == -1 ? -1 : starts[idx][1];
        }

        return result;
    }

    private int binarySearch(int[][] starts, int target) {
        int left = 0, right = starts.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (starts[mid][0] >= target) {
                ans = mid;
                right = mid - 1; // try smaller valid
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}