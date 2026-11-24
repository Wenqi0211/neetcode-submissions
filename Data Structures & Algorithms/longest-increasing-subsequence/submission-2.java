class Solution {
    private int[] memo; 
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(nums, i));
        }
        return res;
    }
    private int dfs(int[] nums, int i) {
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                res = Math.max(res, dfs(nums, j) + 1);
            }
        }
        memo[i] = res;
        return memo[i];
    }
}
