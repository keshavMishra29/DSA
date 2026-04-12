class Solution {
    public int maxLength(List<String> arr) {
        return backtrack(arr, "", 0);
    }

    private int backtrack(List<String> arr, String curr, int index) {
        // agar current string valid nahi hai → reject
        if (!isUnique(curr)) return 0;

        int max = curr.length();

        for (int i = index; i < arr.size(); i++) {
            max = Math.max(max, backtrack(arr, curr + arr.get(i), i + 1));
        }

        return max;
    }

    // check if string has all unique characters
    private boolean isUnique(String s) {
        boolean[] seen = new boolean[26];

        for (char c : s.toCharArray()) {
            if (seen[c - 'a']) return false;
            seen[c - 'a'] = true;
        }

        return true;
    }
}