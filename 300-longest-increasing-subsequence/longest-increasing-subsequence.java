class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n + 1];
        for (int right = 1; right < n; right++) {
            for (int left = 0; left < right; left++) {
                if (nums[left] < nums[right]) {
                    if (len[left] + 1 > len[right]) {
                        len[right] = len[left] + 1;
                    }
                }
            }
        }
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            if (len[maxlen] < len[i]) {
                maxlen = i;
            }
        }
        return len[maxlen] + 1;
    }
}