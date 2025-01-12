class Solution {
    // Variation of LCS ek strig ko dusre string ke jesa krne ke liye lcs nikala or dono ki length ko usse minus krke add krdia vhi hmare required number of operations honge
    public int minDistance(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0|| j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int deletion1=Math.abs(s1.length()-dp[n][m]);
        int deletion2=Math.abs(s2.length()-dp[n][m]);
        return deletion1+deletion2;
    }
}
