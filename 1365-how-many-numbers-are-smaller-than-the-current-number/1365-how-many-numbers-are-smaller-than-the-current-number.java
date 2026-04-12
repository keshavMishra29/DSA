class Solution {
    static {
        for(int i = 0; i < 500; i++)
            smallerNumbersThanCurrent(null);
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        if (nums == null || nums.length == 0) return new int[0];
        int[] loc = new int[101];
        for(int n : nums) loc[n]++;
        int big = 0;
        for(int i = 0 ; i < 101 ; i++){
            if(loc[i] > 0){
                int temp = loc[i];
                loc[i] = big;
                big += temp;
            }
        }
        /*
        []
         */
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = loc[nums[i]];
        }
        return nums;
    }
}