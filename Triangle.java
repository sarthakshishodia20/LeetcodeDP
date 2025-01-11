class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = new int[triangle.get(i).size()];
            for (int j = 0; j < triangle.get(i).size(); j++) {
                a[i][j] = triangle.get(i).get(j);
            }
        }
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[a[i].length];
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(0, 0, a, dp);
    }

    public static int helper(int i, int j, int[][] a, int[][] dp) {
        if (i == a.length - 1) {
            dp[i][j] = a[i][j];
            return dp[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = helper(i + 1, j, a, dp);

        int diagonal = helper(i + 1, j + 1, a, dp);
        dp[i][j] = a[i][j] + Math.min(down, diagonal);
        return dp[i][j];
    }
}
