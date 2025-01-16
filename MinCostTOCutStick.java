class Solution {
    public int minCost(int n, int[] cuts) {
        // arraylist mein add krke cuts ke items put krenge and insert 0 , n to calculate cost in each case like arr[j+1]-arr[i-1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int ele : cuts) {
            list.add(ele);
        }
        list.add(n);
        list.add(0);
        // sorting such that none of the cuts get placed in independent subproblem
        Collections.sort(list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        // +2 for adding 2 extra elements in our array na
        int[][] dp = new int[cuts.length + 2][cuts.length + 2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                // initialise with -1 for dp case
                dp[i][j] = -1;
            }
        }
        // arr , i,j,dp
        return solve(arr, 1, cuts.length, dp);
    }
    public static int solve(int[] arr, int i, int j, int[][] dp) {
        // agr i , j ko cross krke aage chla gya hai means koi cost possible hi nahi hai yahan se toh return krdo 0
        if (i > j) {
            return 0;
        }
        // agr phle se pre solve hai toh return kro yahin se
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // for tracking the mini
        int mini = Integer.MAX_VALUE;
        // here comes the concept of partition of DP or MCM case brute case or template case
        for (int k = i; k <= j; k++) {
            int cost = solve(arr, i, k - 1, dp) + solve(arr, k + 1, j, dp) + (arr[j + 1] - arr[i - 1]);
            mini = Math.min(cost, mini);
        }
        // store and return
        dp[i][j] = mini;
        return dp[i][j];
    }
}
