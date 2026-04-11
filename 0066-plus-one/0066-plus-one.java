class Solution {
    public int[] plusOne(int[] digits) {
        // Traverse from last digit
        for (int i = digits.length - 1; i >= 0; i--) {
            // If digit is less than 9, just increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If digit is 9, set it to 0 and continue
            digits[i] = 0;
        }
        
        // If all digits were 9, create new array
        int[] result = new int[digits.length + 1];
        result[0] = 1; // rest are already 0
        return result;
    }
}