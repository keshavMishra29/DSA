

class Solution {
    public long countGoodSubarrays(int[] nums) {
        int[] qorvanelid = nums;
        long result = 0;

        // groups: [orValue, rightmostLeftBoundary, count]
        // rightmostLeftBoundary = the maximum start index among all subarrays
        //   in this group (i.e., the shortest subarray's start in this group)
        // We need to know: does orValue appear in nums[start..i]?
        // Sufficient condition: lastSeen[orValue] >= start
        
        // lastSeen[v] = most recent index where nums[index] == v
        Map<Integer, Integer> lastSeen = new HashMap<>();
        
        // groups: {orValue, minStart} where minStart = smallest start index
        //   (longest subarray) — we want the RANGE of start indices
        // Actually we need: for subarrays in this group (all ending at i),
        // starting indices range from minStart to maxStart.
        // group is "good" for starts where lastSeen[orValue] >= start
        // i.e., starts <= lastSeen[orValue]
        // count of good = max(0, lastSeen[orValue] - minStart + 1) but capped at group count

        // Simpler: store [orValue, minStart, maxStart]
        List<int[]> groups = new ArrayList<>(); // [orVal, minStart, maxStart]

        for (int i = 0; i < qorvanelid.length; i++) {
            int num = qorvanelid[i];
            lastSeen.put(num, i);

            List<int[]> newGroups = new ArrayList<>();
            newGroups.add(new int[]{num, i, i}); // subarray [i..i]

            for (int[] g : groups) {
                int merged = g[0] | num;
                // Subarrays from g extended by num: start range [g[1], g[2]]
                if (newGroups.get(newGroups.size() - 1)[0] == merged) {
                    int[] last = newGroups.get(newGroups.size() - 1);
                    last[1] = Math.min(last[1], g[1]); // expand minStart
                    // maxStart: max of existing maxStart and g[2]
                    last[2] = Math.max(last[2], g[2]);
                } else {
                    newGroups.add(new int[]{merged, g[1], g[2]});
                }
            }
            groups = newGroups;

            for (int[] g : groups) {
                int orVal = g[0];
                int minStart = g[1];
                int maxStart = g[2]; // = i always for the single-element group

                // Subarrays with this OR value end at i, start in [minStart, maxStart]
                // Total subarrays in group = maxStart - minStart + 1
                // Good ones: those where orVal appears in nums[start..i]
                // orVal appears in [start..i] iff lastSeen[orVal] >= start
                // So good count = number of starts in [minStart, maxStart] 
                //                 where start <= lastSeen.getOrDefault(orVal, -1)
                
                int ls = lastSeen.getOrDefault(orVal, -1);
                if (ls >= minStart) {
                    // starts from minStart to min(maxStart, ls) are good
                    result += Math.min(maxStart, ls) - minStart + 1;
                }
            }
        }

        return result;
    }
}