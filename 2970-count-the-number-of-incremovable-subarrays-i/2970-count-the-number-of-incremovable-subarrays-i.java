class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        // Loop over all non-empty subarrays [i, j]
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isStrictlyIncreasingAfterRemoval(nums, i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    // Helper function to check if array becomes strictly increasing after removing nums[l..r]
    private boolean isStrictlyIncreasingAfterRemoval(int[] nums, int l, int r) {
        int n = nums.length;
        
        // Check left part (nums[0..l-1])
        for (int i = 0; i < l - 1; i++) {
            if (nums[i] >= nums[i + 1]) return false;
        }
        
        // Check right part (nums[r+1..n-1])
        for (int i = r + 1; i < n - 1; i++) {
            if (nums[i] >= nums[i + 1]) return false;
        }
        
        // Check boundary between left and right
        if (l > 0 && r < n - 1) {
            if (nums[l - 1] >= nums[r + 1]) return false;
        }
        
        return true;
    }
}