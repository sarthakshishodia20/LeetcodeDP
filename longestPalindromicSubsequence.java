class Solution {
    public int longestPalindromeSubseq(String s) {
        // Variation of LCS bs string ko reverse krke dusri string bna dia or lcs nikal lia normal or revsered string mein vhi ans hai
        StringBuilder sb=new StringBuilder(s);
        String reverse=sb.reverse().toString();
        return LCS(s,reverse);
    }
    public static int LCS(String a,String b){
        int n=a.length();
        int m=b.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
