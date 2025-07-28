class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n=satisfaction.length;
        int[][] dp=new int[satisfaction.length][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return helper(0,0,satisfaction,dp);
    }
    public static int helper(int index,int time,int[] arr,int[][] dp){
        if(index==arr.length){
            return 0;
        }
        if(dp[index][time]!=-1){
            return dp[index][time];
        }
        int include=arr[index]*(time+1)+helper(index+1,time+1,arr,dp);
        int exclude=0+helper(index+1,time,arr,dp);
        dp[index][time]=Math.max(include,exclude);
        return dp[index][time];
    }
}
