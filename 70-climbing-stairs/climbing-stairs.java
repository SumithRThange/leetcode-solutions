class Solution {
    public int climbStairs(int n) {
        if (n<=2)
        return n;
        int a = 1, b = 2; //a = 1 and b = 2 because possible no of ways is 1 and 2 steps at a time
        for(int i=3; i<=n;i++){
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}