class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int smallest = nums[0] + nums[1] + nums[2];
        if (smallest >= target || n == 3) {
            return smallest;
        }

        int largest = nums[n - 3] + nums[n - 2] + nums[n - 1];
        if (largest <= target) {
            return largest;
        }

        int closest = largest - target < target - smallest ? largest : smallest;
        int l = 0, r = n - 1;

        while (r > l + 1 && nums[l] + nums[l + 1] + nums[r] > target) {
            int sum = nums[l] + nums[l + 1] + nums[r];
            closest = sum - target < Math.abs(target - closest) ? sum : closest;
            r--;
        }

        while (l < r - 1) {
            int sum = closest;
            while (l < r - 1 && nums[l] + nums[l + 1] + nums[r] < target) {
                sum = nums[l] + nums[l + 1] + nums[r];
                l++;
            }

            closest = Math.abs(target - sum) < Math.abs(target - closest) ? sum : closest;
            int mid = l + 1;

            while (l < r - 1 && (0 <= l || mid <= r - 1)) {
                sum = nums[l] + nums[mid] + nums[r];
                closest = Math.abs(target - sum) < Math.abs(target - closest) ? sum : closest;

                if (sum > target) {
                    if (l == 0)
                        break;
                    l--;
                } else if (sum < target) {
                    if (mid == r - 1)
                        break;
                    mid++;
                } else {
                    return closest;
                }
            }

            r--;
            l = 0;
        }

        return closest;
    }
}