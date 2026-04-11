class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(intervals[i][0], max);
        }

        int[] map = new int[max + 1];

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            map[start] = Math.max(map[start], end + 1);
        }

        int startIndex = -1;
        int range = -1;
        int k = 0;

        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                if (startIndex == -1)
                    startIndex = i;
                range = Math.max(map[i] - 1, range);
            }

            if (range == i) {
                intervals[k++] = new int[] { startIndex, range };
                startIndex = -1;
                range = -1;
            }
        }
        if (startIndex != -1) {
            intervals[k++] = new int[] { startIndex, range };

        }

        if (k == n) {
            return intervals;
        }
        int[][] ans = new int[k][];
        for (int i = 0; i < k; i++) {
            ans[i] = intervals[i];
        }
        return ans;

    }
}