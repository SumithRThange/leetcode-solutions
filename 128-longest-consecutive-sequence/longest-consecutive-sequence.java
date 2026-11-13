class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int num: nums){
            set.add(num);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int count = 1;
                int curr = num;
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}