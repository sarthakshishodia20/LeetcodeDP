class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        int maxi = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (KyaYeBanSakteHai(words[i], words[j]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxi = Math.max(maxi, dp[i]); 
        }
        return maxi;
    }
    
    public static boolean KyaYeBanSakteHai(String word1, String word2) {
        if (word1.length() - word2.length() != 1) {
            return false;
        }
        int first = 0;
        int second = 0;
        int count = 0;
        while (first < word1.length() && second < word2.length()) {
            if (word1.charAt(first) == word2.charAt(second)) {
                first++;
                second++;
            } else {
                first++; 
                count++; 
            }
        }
        return count <= 1;
    }
}



