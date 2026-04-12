class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        int[] n=new int[nums.length+1];
        int k=0;
        for(int i:nums){
            n[i]+=1;
            if(n[i]==2){
                k=i;
            }
        }
        int y=((nums.length*(nums.length+1))/2)-(sum-k);
        int[] p = new int[2];
        p[0]=k;
        p[1]=y;
        System.out.println(k+" "+y);
        return p;
        
        
    }
}