class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] array = new int[nums.length];
        //length is 8
        //[1,2,3,4,0,0,7,8]
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            array[val - 1] = val;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                list.add(i + 1);
        }
        return list;

    }
}