
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> dq = new ArrayDeque<>();

        long cost = 0;
        long ans = 0;
        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            int count = 1;

            // Merge smaller groups
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {
                int[] last = dq.pollLast();

                cost += (long) (num - last[0]) * last[1];
                count += last[1];
            }

            dq.offerLast(new int[]{num, count});

            // Shrink window if operations exceed k
            while (cost > k) {
                int[] first = dq.peekFirst();

                cost -= first[0] - nums[j];
                j--;

                first[1]--;

                if (first[1] == 0) {
                    dq.pollFirst();
                }
            }

            // Count valid subarrays
            ans += j - i + 1;
        }

        return ans;
    }
}
