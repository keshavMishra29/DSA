class Solution {
    public int numIdenticalPairs(int[] nums) {
        int freq[] = new int[101];
        int pair = 0;
        for (int num : nums) {
            pair += freq[num];

            freq[num]++;
        }
        return pair;
    }
}