class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        index = list.indexOf(target);
        if (index != -1) {
            return index;
        }
        return -1;
    }
}