class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1;
        int curMax = 1;
        for (int num : nums) {
            int temp = curMax * num;
            curMax = Math.max(num, Math.max(num * curMax, num * curMin));
            curMin = Math.min(num, Math.min(curMin * num, temp));
            res = Math.max(res, Math.max(curMax, curMin));
        }
        return res;
    }
}
