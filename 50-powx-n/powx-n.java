class Solution {
    public double myPow(double x, int n) {
        long N = n;
        boolean negative = N < 0;
        N = Math.abs(N);

        double ans = 1.0;

        while (N > 0) {
            if ((N & 1) == 1) {
                ans *= x;
            }
            x *= x;
            N >>= 1;
        }

        return negative ? 1.0 / ans : ans;
    }
}