class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(m-1,n-1,dp);
    }
    public static int helper(int i,int j,int[][] dp){
        if(i==0 && j==0){
            dp[i][j]=1;
            return dp[i][j];
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left=helper(i,j-1,dp);
        int upward=helper(i-1,j,dp);
        dp[i][j]=left+upward;
        return dp[i][j];
    }
}
