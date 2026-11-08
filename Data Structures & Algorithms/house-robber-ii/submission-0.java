class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robline(nums, 0, n - 1),
        robline(nums, 1, n));
    }
    private int robline(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i < end; i++) {
            int cur = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
