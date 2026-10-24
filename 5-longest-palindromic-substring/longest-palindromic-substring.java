
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        String rev = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n + 1][n + 1];

        int maxLen = 0;
        int endIndex = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    int originalStart = i - dp[i][j];
                    int reverseStart = n - j;

                    if (originalStart == reverseStart) {
                        if (dp[i][j] > maxLen) {
                            maxLen = dp[i][j];
                            endIndex = i;
                        }
                    }
                }
            }
        }

        return s.substring(endIndex - maxLen, endIndex);
    }
}
