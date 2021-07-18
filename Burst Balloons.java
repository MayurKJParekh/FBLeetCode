//leetcode 312 Burst Balloons

/*
time: O(n^3)
space: O(n^2)
*/

class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] newnums = new int[n + 2];
        newnums[0] = 1; 
        newnums[n + 1] = 1;
      	for (int i = 0; i < n; i++) {
            newnums[i + 1] = nums[i];  
      	}  
      	int[][] dp = new int[n + 2][n + 2];
      	return helper(newnums, dp, 1, n);  
    }
    private int helper(int[] nums, int[][] dp, int s, int e) {
        if (s > e) return 0;
        if (dp[s][e] > 0) {
            return dp[s][e];  
        }
        int max = 0;
        for (int i = s; i <= e; i++) {
            int cur = nums[s - 1] * nums[i] * nums[e + 1];
            int left = helper(nums, dp, s, i - 1);
            int right = helper(nums, dp, i + 1, e);
            max = Math.max(cur + left + right, max);
        }
        dp[s][e] = max;
        return max;
    }
}

/*
Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
*/
