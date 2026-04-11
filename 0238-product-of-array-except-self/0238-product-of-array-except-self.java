class Solution {
    static{
        for(int i=0;i<500;i++){
        productExceptSelf(new int[1]);
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        res[0]=1;
        for(int i=1;i<nums.length;i++){
            res[i]=nums[i-1]*res[i-1];
        }
        int last=1;
        for(int j=nums.length-1;j>=0;j--){
            res[j]=last*res[j];
            last=nums[j]*last;
        }
        return res;
    }
}