class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int prev2 = 0;
        int prev1 = 1;
        for (int i = 1; i <= n; i++) {
            int cur = 0;
            if (s.charAt(i - 1) != '0') {
                cur += prev1;
            }
            if (i >= 2) {
                int two = 10 * (s.charAt(i - 2) - '0') + (s.charAt(i - 1) - '0');
                if (two >= 10 && two <= 26) {
                    cur += prev2;
                }
            }
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
