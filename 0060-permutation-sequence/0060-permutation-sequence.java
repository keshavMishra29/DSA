class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        
        // create list [1, 2, ..., n] and factorial of n-1
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            if (i < n) fact *= i;
        }
        
        StringBuilder sb = new StringBuilder();
        k--; // convert k to 0-indexed
        
        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact;
            sb.append(numbers.get(index));
            numbers.remove(index);
            
            if (i > 0) {
                k %= fact;
                fact /= i;
            }
        }
        
        return sb.toString();
    }
}