class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int first = -1;
        int last = -1;

        for(int i = 0; i < n; i++){
            if(nums[i] == target){
                first = i;
                break;
            }
        }
        for(int i = n-1; i >= 0; i--){
            if(nums[i] == target){
                last = i;
                break;
            }
        }
        int ans[] = new int [2];

        for(int i = 0; i < ans.length-1; i++){
            ans[i] = first;
            ans[i+1] = last;
        }
        return ans;
    }
}