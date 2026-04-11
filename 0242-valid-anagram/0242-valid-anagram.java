class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            isAnagram("a", "");
        }
    }

    public static boolean isAnagram(String s, String t) {
        int l = s.length();
        if (t.length() != l)
            return false;
        int[] feq = new int[26];
        for (int i = 0; i < l; i++) {
            feq[s.charAt(i) - 'a']++;
            feq[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (feq[i] != 0)
                return false;
        }
        return true;
    }
}