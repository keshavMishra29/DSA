class Solution {
    public List buildArray(int[] target, int n) {
        List result = new ArrayList<>();
        int streamCurrent = 1;

        for (int num : target) {
            while (streamCurrent < num) {
                result.add("Push");
                result.add("Pop");
                streamCurrent++;
            }
            result.add("Push");
            streamCurrent++;
        }
        return result;
    }
}