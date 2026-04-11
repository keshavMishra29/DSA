
class Solution {
    public String generateString(String S, String t) {
        char[] s = S.toCharArray();
        int n = s.length;
        int m = t.length();
        char[] ans = new char[n + m - 1];
        Arrays.fill(ans, '?');

        int[] z = calcZ(t);
        int pre = -m;
        for (int i = 0; i < n; i++) {
            if (s[i] != 'T') {
                continue;
            }
            int size = Math.max(pre + m - i, 0);

            if (size > 0 && z[m - size] < size) {
                return "";
            }

            for (int j = size; j < m; j++) {
                ans[i + j] = t.charAt(j);
            }
            pre = i;
        }

        int[] preQ = new int[ans.length];
        pre = -1;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == '?') {
                ans[i] = 'a';
                pre = i;
            }
            preQ[i] = pre;
        }

        z = calcZ(t + new String(ans));

        for (int i = 0; i < n; i++) {
            if (s[i] != 'F') {
                continue;
            }

            if (z[m + i] < m) {
                continue;
            }

            int j = preQ[i + m - 1];
            if (j < i) {
                return "";
            }
            ans[j] = 'b';
            i = j;
        }

        return new String(ans);
    }

    private int[] calcZ(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] z = new int[n];
        int boxL = 0;
        int boxR = 0;
        for (int i = 1; i < n; i++) {
            if (i <= boxR) {
                z[i] = Math.min(z[i - boxL], boxR - i + 1);
            }
            while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
                boxL = i;
                boxR = i + z[i];
                z[i]++;
            }
        }
        z[0] = n;
        return z;
    }
}