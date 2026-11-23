class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        int n = s.length();
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String w : wordDict) {
                if (w.length() <= i && dp[i - w.length()] && s.substring(i - w.length(), i).equals(w)) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
