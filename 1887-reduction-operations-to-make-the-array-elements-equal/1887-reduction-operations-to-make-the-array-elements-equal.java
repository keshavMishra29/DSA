class Solution {
    public int reductionOperations(int[] nums) {
        int res = 0, sz = nums.length;
        Arrays.sort(nums);
        for (int i = sz - 1; i > 0; --i) {
            if (nums[i - 1] != nums[i])
                res += sz - i;
        }
        return res;
    }
}