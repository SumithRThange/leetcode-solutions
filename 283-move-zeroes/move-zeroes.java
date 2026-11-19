class Solution {
    public void moveZeroes(int[] nums) {
      int left = 0, right = 0, temp = 0;
      while(left<nums.length && right<nums.length){
        if(nums[right] != 0){
            temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
        }
        right ++;
      }  
    }
}