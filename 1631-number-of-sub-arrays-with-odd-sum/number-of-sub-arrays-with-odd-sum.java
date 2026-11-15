class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007, even = 1, odd = 0, sum = 0, count = 0;
        for(int num : arr){
            sum += num;
            if(sum % 2 == 0){
                count = (count + odd) % mod;
                even ++;
            } else {
                count = (count + even) % mod;
                odd ++;
            }
        }
        return count;
    }
}