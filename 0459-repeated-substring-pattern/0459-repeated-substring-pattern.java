class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();
        int v = n;
        int t = 1;
        int ct = 0;
        int cur = n;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i != 0)
                continue;
            boolean f = false;
            String str = s.substring(0, i);
            v = str.length();
            for (int j = 0; j < n; j += i) {
                if (!str.equals(s.substring(j, j + v))) {
                    f = true;
                    break;
                }
            }
            if (!f)
                return true;

        }
        return false;
    }
}