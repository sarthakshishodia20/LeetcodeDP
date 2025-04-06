class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); 
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] previous = new int[n];
        Arrays.fill(previous, -1);
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] % nums[j] == 0) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    previous[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        int current = maxIndex;
        while (current != -1) {
            list.add(nums[current]);
            current = previous[current];
        }
        Collections.reverse(list);
        return list;
    }
}
