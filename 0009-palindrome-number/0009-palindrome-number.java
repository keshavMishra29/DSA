class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int originalNumber = x;
        int reverse = 0;

        while (x > 0) {
            int lastDigit = x % 10;
            reverse = reverse * 10 + lastDigit;
            x = x / 10;
        }
        return (originalNumber == reverse);
    }
}