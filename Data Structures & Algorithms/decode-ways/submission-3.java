class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return f(s, s.length());
    }
    private int f(String s, int i) {
        if (i == 0) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int res = 0;
        if (s.charAt(i - 1) != '0') {
            res += f(s, i - 1);
        }
        if (i >= 2) {
            int two = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (two >= 10 && two <= 26) {
                res += f(s, i - 2);
            }
        }
        dp[i] = res;
        return res;
    }
        
    
}