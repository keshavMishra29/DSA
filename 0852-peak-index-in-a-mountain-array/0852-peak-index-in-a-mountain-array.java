class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int start = 1;
        int end = n - 2;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid - 1] < arr[mid]) {
                start = mid + 1;   // Increasing slope
            } else {
                end = mid - 1;     // Decreasing slope
            }
        }
        return start;
    }
}