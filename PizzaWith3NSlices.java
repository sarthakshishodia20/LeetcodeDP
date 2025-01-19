class Solution {
    // House Robber Variant ek baar last element exclude krke dekho kitna mila ek baar first element exclude krke pizza slices jitne number of slices /3 pick kr skte hai uske alava dono cases ke liye dp;s alag bnengei 
    public int maxSizeSlices(int[] slices) {
        int n=slices.length;
        int[][] dp1=new int[n][n/3 +1];
        int[][] dp2=new int[n][n/3+1];
        for(int[] dp:dp1){
            Arrays.fill(dp,-1);
        }
        for(int[] dp:dp2){
            Arrays.fill(dp,-1);
        }
        return Math.max(func(slices,0,n-2,n/3,dp1),func(slices,1,n-1,n/3,dp2));
    }
    public static int func(int[] slices,int index,int endIndex,int slicesToPick,int[][] dp){
        if(slicesToPick==0){
            return 0;
        }
        if(index>endIndex){
            return 0;
        }
        if(dp[index][slicesToPick]!=-1){
            return dp[index][slicesToPick];
        }
        int iPick=slices[index]+func(slices,index+2,endIndex,slicesToPick-1,dp);
        int noPick=0+func(slices,index+1,endIndex,slicesToPick,dp);
        dp[index][slicesToPick]=Math.max(iPick,noPick);
        return dp[index][slicesToPick];
    }
}
