import java.util.*;

class Solution {

    class Window {
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        int lowSize = 0, highSize = 0;
        long lowSum = 0, highSum = 0;

        void add(int num) {
            if (low.isEmpty() || num <= low.lastKey()) {
                low.merge(num, 1, Integer::sum);
                lowSize++;
                lowSum += num;
            } else {
                high.merge(num, 1, Integer::sum);
                highSize++;
                highSum += num;
            }
            balance();
        }

        void remove(int num) {
            if (low.containsKey(num)) {
                erase(low, num);
                lowSize--;
                lowSum -= num;
            } else {
                erase(high, num);
                highSize--;
                highSum -= num;
            }
            balance();
        }

        void erase(TreeMap<Integer, Integer> map, int num) {
            if (map.get(num) == 1) {
                map.remove(num);
            } else {
                map.put(num, map.get(num) - 1);
            }
        }

        void balance() {
            int target = (lowSize + highSize + 1) / 2;

            while (lowSize > target) {
                int num = low.lastKey();
                erase(low, num);
                lowSize--;
                lowSum -= num;

                high.merge(num, 1, Integer::sum);
                highSize++;
                highSum += num;
            }

            while (lowSize < target) {
                int num = high.firstKey();
                erase(high, num);
                highSize--;
                highSum -= num;

                low.merge(num, 1, Integer::sum);
                lowSize++;
                lowSum += num;
            }
        }

        long getCost() {
            long median = low.lastKey();

            return median * lowSize - lowSum
                    + highSum - median * highSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // Calculate cost of every window
        long[] cost = new long[n - x + 1];

        Window window = new Window();

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        for (int i = 0; i <= n - x; i++) {
            cost[i] = window.getCost();

            if (i < n - x) {
                window.remove(nums[i]);
                window.add(nums[i + x]);
            }
        }

        // Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
            row[0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                // Skip current element
                dp[i][j] = dp[i - 1][j];

                // Select a window of size x
                if (i >= x) {
                    dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i - x][j - 1] + cost[i - x]);
                }
            }
        }

        return dp[n][k];
    }
}