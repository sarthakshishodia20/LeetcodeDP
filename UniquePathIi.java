class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Same question hai unique path i jesa bs ek extra condition join hui hai that is agr matrix of i,j ==-1 hai toh 0 return kro means obstacle ke through koi path nahi bna skta
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(dp.length-1,dp[0].length-1,dp,obstacleGrid);
    }
    public static int helper(int i,int j,int[][] dp,int[][] matrix){
        if(matrix[0][0]==1){
            return 0;
        }
        if(i==0 && j==0){
            dp[i][j]=1;
            return dp[i][j];
        }
        if(i<0 || j<0){
            return 0;
        }
        if(i>=0 && j>=0 && matrix[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int leftMove=helper(i,j-1,dp,matrix);
        int upMove=helper(i-1,j,dp,matrix);
        dp[i][j]=leftMove+upMove;
        return dp[i][j];
    }
}
