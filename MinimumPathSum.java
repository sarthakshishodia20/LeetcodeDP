class Solution {
    public int minPathSum(int[][] grid) {
        // Striver Sheets' Soln 
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(grid.length - 1, grid[0].length - 1, grid, dp);
    }

    public static int helper(int i, int j, int[][] a, int[][] dp) {
        if (i == 0 && j == 0) {
            dp[i][j] = a[0][0];
            return dp[i][j];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE; 
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int upward = Integer.MAX_VALUE;
        int leftward = Integer.MAX_VALUE;
        if (i > 0) {
            upward = a[i][j] + helper(i - 1, j, a, dp);
        }
        if (j > 0) {
            leftward = a[i][j] + helper(i, j - 1, a, dp);
        }
        dp[i][j] = Math.min(leftward, upward);
        return dp[i][j];
    }
}
