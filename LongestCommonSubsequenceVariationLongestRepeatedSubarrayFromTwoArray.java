class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // Also a variation of LCS Longest common subsequence nikal lo vahi maximum length hogi repeated subaray ki
        int ans=LCSOfBoth(nums1,nums2);
        return ans;
    }
    public static int LCSOfBoth(int[] arr1,int[] arr2){
        int n=arr1.length;
        int m=arr2.length;
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=0;
        }
        for(int j=0;j<m;j++){
            dp[0][j]=0;
        }
        int maxLength=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1]==arr2[j-1])
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                    maxLength=Math.max(1+dp[i-1][j-1],maxLength);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return maxLength;
        
    }
}
