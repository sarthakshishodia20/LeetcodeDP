class Solution {
    public boolean canPartition(int[] nums) {
        // Ek dm same question hai and variation of bounded knapsack or 0 -1  knapsack 
        // krna kch nahi hai sbka sum calcuate kro or half sum nikalo fir ye check kro ki available elements hmara ye sum bna skte hai ya nahi or vo sum nikal lo totalSum mein se vo sum minus krke check kro ki dono ki value equal hai ya nahi agr equal hai mtlb equal subset me divide kr skte hai pure variation of 0-1 knapsack
        int sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2!=0){
            return false;
        }
        int W=sum/2;
        int n=nums.length;
        int[][] dp=new int[n+1][W+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                // include
                if(nums[i-1]<=j){
                    int include=nums[i-1]+dp[i-1][j-nums[i-1]];
                    int exclude=dp[i-1][j];
                    dp[i][j]=Math.max(include,exclude);
                }
                // Exclude kro hmesha
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int sumbna=dp[n][W];
        int sum2=sum-sumbna;
        return sumbna==sum2;
    }
}
