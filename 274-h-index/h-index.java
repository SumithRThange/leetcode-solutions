class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length, count = 0;
        int[] freq = new int[length+1];
        for(int citationfreq : citations){
            freq[Math.min(length, citationfreq)]++;
        }
        for(int i = length; i>=0; i--){
            count += freq[i];
            if(count >= i){
                return i;
            }
        }
        return 0;
    }
}