class Solution {
    public int tribonacci(int n) {
        if (n < 3) {
            if (n == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int current = a + b + c;
            a = b;
            b = c;
            c = current;
        }
        return c;
    }
}