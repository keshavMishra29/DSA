class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Find Min and Max to handle negative numbers and range
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // 2. Use Simple array for counting 
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }

        // 3. Make Buckets : Based on frequency 
        
        int maxFreq = 0;
        for (int c : count) {
            if (c > maxFreq) maxFreq = c;
        }

        
    
        int[][] buckets = new int[maxFreq + 1][];
        int[] bucketSize = new int[maxFreq + 1];

    
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                bucketSize[count[i]]++;
            }
        }


        for (int i = 0; i <= maxFreq; i++) {
            if (bucketSize[i] > 0) {
                buckets[i] = new int[bucketSize[i]];
                bucketSize[i] = 0; 
            }
        }

        // Fill Buckets 
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                int f = count[i];
                buckets[f][bucketSize[f]++] = i + min;
            }
        }

        // 4. Find Result from down 
        int[] result = new int[k];
        int idx = 0;
        for (int f = maxFreq; f >= 0 && idx < k; f--) {
            if (buckets[f] != null) {
                for (int val : buckets[f]) {
                    result[idx++] = val;
                    if (idx == k) return result;
                }
            }
        }

        return result;
    }
}