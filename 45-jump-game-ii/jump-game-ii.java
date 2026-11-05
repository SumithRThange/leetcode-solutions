class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int current = 0;
        int fa = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            fa = Math.max(fa, i + nums[i]);
            if (i == current) {
                jumps++;
                current = fa;
            }
        }
        return jumps;
    }
}