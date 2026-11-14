class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int min = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int sum = 0;

            for (int end = start; end < n && end < start + r; end++) {
                sum += nums.get(end);

                int len = end - start + 1;

                if (len >= l && sum > 0) {
                    min = Math.min(min, sum);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}