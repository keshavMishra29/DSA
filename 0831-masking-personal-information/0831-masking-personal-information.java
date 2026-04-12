class Solution {
    public String maskPII(String s) {

        StringBuilder ans = new StringBuilder();

        if (Character.isLetter(s.charAt(0))) {
            s = s.toLowerCase();
            int at = s.indexOf('@');
            ans.append(s.charAt(0));
            ans.append("*****");
            ans.append(s.charAt(at - 1));
            ans.append(s.substring(at));
            return ans.toString();
        } else {
            StringBuilder cleaned = new StringBuilder();

            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    cleaned.append(ch);
                }
            }
            int len = cleaned.length();

            StringBuilder nans = new StringBuilder();
            nans.append("***-***-");
            nans.append(cleaned.substring(len - 4));

            if (len == 10) {
                return nans.toString();
            }

            if (len == 11) {
                ans.append("+*-");
                ans.append(nans);
                return ans.toString();
            }

            if (len == 12) {
                ans.append("+**-");
                ans.append(nans);
                return ans.toString();
            }

            ans.append("+***-");
            ans.append(nans);
            return ans.toString();
        }
    }
}