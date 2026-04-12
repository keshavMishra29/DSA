class Solution {
    static {
        int[] temp = {30, 60, 90};
        for(int i = 0; i < 500; i++)
            dailyTemperatures(temp);
    }
    
    public static int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;

            while (j < n && temp[j] <= temp[i]) {
                if (ans[j] == 0) {
                    j = n;
                } else {
                    j += ans[j]; 
                }
            }
            
            if (j < n) {
                ans[i] = j - i;
            }
        }
        
        return ans;
    }
}