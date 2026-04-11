class Solution {
    public int magicalString(int n) {
        if (n <= 0)
            return 0;
        if (n <= 3)
            return 1; // "122"

        int[] s = new int[n];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int countOnes = 1; // we already have one '1'
        int i = 2; // pointer to read counts
        int index = 3; // next position to fill
        int num = 1; // next number to insert

        while (index < n) {
            int times = s[i]; // how many times to insert

            for (int j = 0; j < times && index < n; j++) {
                s[index] = num;
                if (num == 1)
                    countOnes++;
                index++;
            }

            num = (num == 1) ? 2 : 1; // alternate
            i++;
        }

        return countOnes;
    }
}