class Solution {
    // Variation of LCS agr longest common subsequnce a length ke equal hai mtlb ki vo a puri hi string b ka part hai verma's post;
    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m]==s.length();
    }
}
