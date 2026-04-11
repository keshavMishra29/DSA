class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int left = 0, right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Find row index of max element in mid column
            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }
            
            int leftVal = (mid - 1 >= 0) ? mat[maxRow][mid - 1] : -1;
            int rightVal = (mid + 1 < n) ? mat[maxRow][mid + 1] : -1;
            
            // Check if peak
            if (mat[maxRow][mid] > leftVal && mat[maxRow][mid] > rightVal) {
                return new int[]{maxRow, mid};
            } 
            else if (leftVal > mat[maxRow][mid]) {
                right = mid - 1; // move left
            } 
            else {
                left = mid + 1; // move right
            }
        }
        
        return new int[]{-1, -1}; // should never happen
    }
}