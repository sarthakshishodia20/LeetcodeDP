class Solution {
    int lcsOf3(String A, String B, String C) {
        // code here
        int a = A.length();
        int b = B.length();
        int c = C.length();

        int[][][] dp = new int[a + 1][b + 1][c + 1];

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    if (A.charAt(i - 1) == B.charAt(j - 1) && A.charAt(i - 1) == C.charAt(k - 1)) {
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    } else {
                        dp[i][j][k] = Math.max(
                            Math.max(dp[i - 1][j][k], dp[i][j - 1][k]),
                            dp[i][j][k - 1]
                        );
                    }
                }
            }
        }

        return dp[a][b][c];
    }
}
