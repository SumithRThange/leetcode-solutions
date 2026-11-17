class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1000000;

        // Step 1: Precompute cost of every substring
        int[][] cost = new int[n][n + 1];

        for (int l = 0; l < n; l++) {
            for (int r = l + 2; r <= n; r++) {

                int len = r - l;
                int minCost = INF;

                // Try every proper divisor
                for (int d = 1; d < len; d++) {
                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Compare symmetric characters in each group
                    for (int x = 0; x < d; x++) {
                        int left = l + x;
                        int right = l + x + ((len - 1 - x) / d) * d;

                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    minCost = Math.min(minCost, changes);
                }

                cost[l][r] = minCost;
            }
        }

        // Step 2: DP
        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        // Number of partitions
        for (int p = 1; p <= k; p++) {

            // Current prefix length
            for (int i = 2 * p; i <= n; i++) {

                // Try every possible previous partition
                for (int j = 2 * (p - 1); j <= i - 2; j++) {

                    dp[p][i] = Math.min(
                            dp[p][i],
                            dp[p - 1][j] + cost[j][i]);
                }
            }
        }

        return dp[k][n];
    }
}