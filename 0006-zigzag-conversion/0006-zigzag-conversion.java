class Solution {
    public String convert(String s, int numRows) {

        int n = s.length();
        if (numRows == 1 || numRows >= n) return s;

        char[] result = new char[n];
        int index = 0;
        int cycle = 2 * (numRows - 1);

        for (int i = 0; i < numRows; i++) {

            for (int j = i; j < n; j += cycle) {

                result[index++] = s.charAt(j);

                int diagonal = j + cycle - 2 * i;

                if (i != 0 && i != numRows - 1 && diagonal < n) {
                    result[index++] = s.charAt(diagonal);
                }
            }
        }

        return new String(result);
    }
}