class Solution {
    public int numDecodings(String s) {
        if(s.length()==0 || s.charAt(0)=='0'){
            return 0;
        }
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        int n=s.length();
        for(int i=2;i<=n;i++){
            int oneDigit=Integer.valueOf(s.substring(i-1,i));
            if(oneDigit>=1){
                dp[i]+=dp[i-1];
            }
            int twoDigit=Integer.valueOf(s.substring(i-2,i));
            if(twoDigit>=10 && twoDigit<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[n];
    }
}
