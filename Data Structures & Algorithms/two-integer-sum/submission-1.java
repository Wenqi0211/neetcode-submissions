class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compensation = target - nums[i];
            if (map.containsKey(compensation)) {
                return new int[] {map.get(compensation), i};

            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
