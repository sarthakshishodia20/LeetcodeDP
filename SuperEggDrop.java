class Solution {
    public int superEggDrop(int k, int n) {
        // Variation of MCM Dynammic Programming
        int[][] dp = new int[k + 1][n + 1];
        // initialisation of dp with -1
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(k, n, dp);
    }
    
    public int solve(int e, int f, int[][] dp) {
        // Base cases
        if (e == 1) return f;  // with one egg, you need to try all floors
        if (f == 0 || f == 1) return f;  // if there are no floors or one floor, f trials
        // return preSolve problems
        if (dp[e][f] != -1) {
            return dp[e][f];
        }
        // we are using binary search here 
        int low = 1, high = f;
        int mini= Integer.MAX_VALUE;
        while (low <= high) {
            int k= low + (high - low) / 2;
            int breakCase = solve(e - 1, k- 1, dp);
            int noBreakCase = solve(e, f - k, dp);
            // worst case ke liye max lia hua hai as mentioned in question
            int temp = 1 + Math.max(breakCase, noBreakCase);
            // pr attempts hmko minimum hi chahiye
            mini = Math.min(mini, temp);
            // agr breakCases jyada hai means break ho rha hai then we have to search now int below floors agr nahi ho rha tb upr wale maalo pr jake dekho
            if (breakCase > noBreakCase) {
                high = k- 1;
            } else {
                low = k + 1;
            }
        }
        
        // store and return ans
        dp[e][f] = mini;
        return mini;
    }
}
