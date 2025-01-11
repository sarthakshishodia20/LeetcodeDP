class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int upward = dp[i-1][j] + matrix[i][j];
                int upwardLeft = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    upwardLeft = dp[i-1][j-1] + matrix[i][j];
                }
                int upwardRight = Integer.MAX_VALUE;
                if (j + 1 < m) {
                    upwardRight = dp[i-1][j+1] + matrix[i][j];
                }
                dp[i][j] = Math.min(upward, Math.min(upwardLeft, upwardRight));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[n-1][j]);
        }
        return ans;
    }
}
