class Solution {
    // Dp on String Striver sheet soln simply agr last char equal hai toh choice hai inclue kro ya exclude kro or dono ke count of ways btao vrna toh exclude krke dp mein put krdo last mein dp[n][m] ke paas answer store hoke aaega 
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            // agr length of t hmari zero ho jaye ya empty ho jaye toh hrr character se bnane ke ways honge 1
            dp[i][0] = 1;
        }
        for (int j = 1; j <= m; j++) {
            // agr string s1 hi empty ho jaye toh no possible way to make subsequence from s1 thus uske liye 0 aaega hrr character ke liye 
            dp[0][j] = 0;

        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m]; 
    }
}
