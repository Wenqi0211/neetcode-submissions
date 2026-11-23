class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //hashSet + maxLen; tc: O(m*maxLen+n*maxLen²) sc: O(n + m*maxLen)
        boolean[] dp = new boolean[s.length() + 1];
        int n = s.length();
        dp[0] = true;
        int maxLen = 0;
        HashSet<String> set = new HashSet<>();
        for (String w : wordDict) {
            maxLen = Math.max(maxLen, w.length());
            set.add(w);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - maxLen); j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
