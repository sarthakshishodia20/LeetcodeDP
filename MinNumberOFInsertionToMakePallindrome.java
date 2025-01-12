class Solution {
    // variation of LCS and is equal to minimum number of deletion to make a string palindrome phle palindrome nikal lia longest uske baad minium number of operation nikalne ke lye string ki length se minus kr dia LPS ki length ko or LPS nikalne ke liye string dia hua hai usko reverse krne ke saath bs Longest Common Subsequence nikalna hai 
    public int minInsertions(String s) {
        StringBuilder reversed = new StringBuilder(s);
        return s.length() - LPS(s, reversed.reverse().toString());
    }
    public static int LPS(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
