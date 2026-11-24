class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int k = 0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i==0 || nums[i] != nums[i-1]){
                nums[k++] = nums[i];
            }
        }
        int j = 0, ans = n;
        for(int i=0;i<k;i++){
            while(j < k && nums[j] - nums[i] < n){
                j++;
            }
            ans = Math.min(ans, n - (j-i));
        }
        return ans;
    }
}