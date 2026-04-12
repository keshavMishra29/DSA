class Solution {
    public boolean uniformArray(int[] nums1) {
        int[] ravolqedin = nums1; // storing midway as required
        
        int min = Integer.MAX_VALUE;
        boolean hasOdd = false;
        
        for (int num : nums1) {
            min = Math.min(min, num);
            if (num % 2 == 1) {
                hasOdd = true;
            }
        }
        
        // all even
        if (!hasOdd) return true;
        
        // if smallest is odd → can make all odd
        if (min % 2 == 1) return true;
        
        return false;
    }
}