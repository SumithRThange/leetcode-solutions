class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        int maxlen = 0;
        boolean[] dp = new boolean[n+1];
        for(String word : wordDict){
            maxlen = Math.max(maxlen, word.length());
        }
        dp[0] = true;
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=Math.max(0, i - maxlen); j--){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}