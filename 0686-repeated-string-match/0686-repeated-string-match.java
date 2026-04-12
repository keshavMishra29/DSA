class Solution {
    public int repeatedStringMatch(String a, String b) {
        if (b.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<a.length(); i++){
            set.add(a.charAt(i));
        }

        for(int i=0; i<b.length(); i++){
            if(!set.contains(b.charAt(i))) return -1;
        }
        var n = Math.ceilDiv(b.length(), a.length()) + 2;
        boolean f = a.repeat(n).contains(b);
        if (!f) return - 1;
        while (true) {
            if (a.repeat(n - 1).contains(b)) {
                n--;
            } else {
                break;
            }
        }
        return n;
    }
}