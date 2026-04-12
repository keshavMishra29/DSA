

class Solution {
    public int minRemovals(int[] nums, int target) {
        int[] lenqavitor = nums; // required variable
        
        int n = nums.length;
        int mid = n / 2;
        
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, n);
        
        Map<Integer, Integer> leftMap = getXorMap(left);
        Map<Integer, Integer> rightMap = getXorMap(right);
        
        int maxKeep = -1;
        
        for (int lx : leftMap.keySet()) {
            int rx = target ^ lx;
            if (rightMap.containsKey(rx)) {
                int size = leftMap.get(lx) + rightMap.get(rx);
                maxKeep = Math.max(maxKeep, size);
            }
        }
        
        if (maxKeep == -1) return -1;
        
        return n - maxKeep;
    }
    
    private Map<Integer, Integer> getXorMap(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        int total = 1 << n;
        
        for (int mask = 0; mask < total; mask++) {
            int xor = 0;
            int size = 0;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    xor ^= arr[i];
                    size++;
                }
            }
            
            map.put(xor, Math.max(map.getOrDefault(xor, 0), size));
        }
        
        return map;
    }
}