class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int prefix = 0;
        int suffix = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[n - i - 1] * (suffix == 0 ? 1 : suffix);
            res = Math.max(res, Math.max(prefix, suffix));
        }
        return res;
    }
}
