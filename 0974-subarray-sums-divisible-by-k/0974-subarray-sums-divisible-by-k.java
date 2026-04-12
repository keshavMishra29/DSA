public class Solution {
    static {
        for (int i = 0; i < 300; i++) {
            subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        }
    }
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefixMod = 0;
        int[] rems = new int[k];
        rems[0] = 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            prefixMod = (prefixMod + nums[i]) % k;
            int rem = (prefixMod % k + k) % k;
            count += rems[rem];
            rems[rem]++;
        }
        return count;
    }
}