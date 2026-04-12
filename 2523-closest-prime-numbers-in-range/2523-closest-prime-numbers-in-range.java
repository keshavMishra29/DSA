class Solution {
    public int[] closestPrimes(int left, int right) {
        int prev=-1;
        int[] result= {-1,-1};       
        int minDiff = Integer.MAX_VALUE;
        for(int i = left; i<= right; i++){
            if(isPrimeNum(i)){
                if(prev != -1){
                    int diff = i - prev;
                    if(diff < minDiff){
                        minDiff = diff;
                        result[0] = prev;
                        result[1] = i;
                    }
                    //Early eixt
                    if(diff == 2){
                        return result;
                    }
                }
                prev = i;
            }
        }
        return result;
    }
     public static boolean isPrimeNum(int n){
        if(n <= 1) return false;
        if(n ==2) return true;
        if(n%2 ==0) return false;
        for(int i = 3; i*i <= n; i+=2){
            if(n%i ==0){
                return false;
            }
        }
        return true;
    }
}