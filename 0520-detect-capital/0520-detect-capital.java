class Solution {
    public boolean detectCapitalUse(String word) {
        
        // Case 1: all uppercase
        if (word.equals(word.toUpperCase())) {
            return true;
        }
        
        // Case 2: all lowercase
        if (word.equals(word.toLowerCase())) {
            return true;
        }
        
        // Case 3: first uppercase, rest lowercase
        if (Character.isUpperCase(word.charAt(0)) &&
            word.substring(1).equals(word.substring(1).toLowerCase())) {
            return true;
        }
        
        return false;
    }
}