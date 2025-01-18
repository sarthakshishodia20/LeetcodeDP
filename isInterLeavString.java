class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false; 
        }
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return func(0, 0, 0, s1, s2, s3, dp);
    }
    public static boolean func(int i, int j, int k, String s1, String s2, String s3, Boolean[][] dp) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j]; 
        }
        boolean case1 = false, case2 = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            case1 = func(i + 1, j, k + 1, s1, s2, s3, dp);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            case2 = func(i, j + 1, k + 1, s1, s2, s3,dp);
        }
        dp[i][j] = case1 || case2;
        return dp[i][j];
    }
}
