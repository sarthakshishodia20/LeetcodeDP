import java.util.*;
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4]; 
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return maxHelper(n - 1, 3, points, dp);
    }

    public static int maxHelper(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1) {
            return dp[day][last];
        }
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[day][i]);
                }
            }
            dp[day][last] = maxi;
            return dp[day][last];
        }
        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int maxPoints = maxHelper(day - 1, i, points, dp) + points[day][i];
                maxi = Math.max(maxi, maxPoints);
            }
        }
        dp[day][last] = maxi;
        return dp[day][last];
    }
}
