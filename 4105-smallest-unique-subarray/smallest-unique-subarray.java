class Solution {
    static final long MOD1 = 1_000_000_007L;
    static final long MOD2 = 1_000_000_009L;

    static final long BASE1 = 911382323L;
    static final long BASE2 = 972663749L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (hasUnique(nums, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean hasUnique(int[] nums, int len) {
        int n = nums.length;

        long pow1 = 1;
        long pow2 = 1;

        for (int i = 0; i < len; i++) {
            pow1 = (pow1 * BASE1) % MOD1;
            pow2 = (pow2 * BASE2) % MOD2;
        }

        long h1 = 0;
        long h2 = 0;

        // Calculate first window hash
        for (int i = 0; i < len; i++) {
            h1 = (h1 * BASE1 + nums[i]) % MOD1;
            h2 = (h2 * BASE2 + nums[i]) % MOD2;
        }

        Map<Long, Integer> map = new HashMap<>();

        add(map, h1, h2);

        // Slide the window
        for (int i = len; i < n; i++) {
            int old = nums[i - len];
            int curr = nums[i];

            h1 = (h1 * BASE1 + curr - old * pow1 % MOD1 + MOD1) % MOD1;

            h2 = (h2 * BASE2 + curr - old * pow2 % MOD2 + MOD2) % MOD2;

            add(map, h1, h2);
        }

        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }

    private void add(Map<Long, Integer> map, long h1, long h2) {
        long key = (h1 << 32) | h2;
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
}